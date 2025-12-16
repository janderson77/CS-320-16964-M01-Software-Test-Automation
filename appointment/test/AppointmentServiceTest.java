package com.appointment.test;

import static org.junit.jupiter.api.Assertions.*;

import com.appointment.Appointment;
import com.appointment.AppointmentService;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AppointmentServiceTest {
	private AppointmentService service;
	
	@BeforeEach
	void setUp() {
		service = new AppointmentService();
		service.addAppointment(new Appointment("1234567890", LocalDate.of(2030, 10, 31), "Appointment Description"));
	}
	
	@Test
	void testAddAppointmentSuccess() {
		assertTrue(service.addAppointment(new Appointment("321654987", LocalDate.of(2027, 12, 25), "Appointment Description")));
	}
	
	@Test
	void testAddAppointmentIdDuplicateFail() {

		assertFalse(service.addAppointment(new Appointment("1234567890", LocalDate.of(2030, 10, 31), "Appointment Description")));

	}
	
	@Test
	void testAddAppointmentIdNullFail() {
		try {
			service.addAppointment(new Appointment(null, LocalDate.of(2030, 10, 31), "Appointment Description"));
		}
		catch(Exception e) {
			// success
		}
	}
	
	@Test
	void testDeleteAppointment() {
		assertTrue(service.removeAppointment("1234567890"));
		assertNull(service.getAppointment("1234567890"));
	}
	
	@Test
	void testDeleteAppointmentNoAppointmentFail() {
		assertFalse(service.removeAppointment("9999999999"));
	}
	
	@Test
	void testDeleteAppointmentNullIdFail() {
		assertFalse(service.removeAppointment(null));
	}
	
	
	@Test
	void testUpdateAppointmentDate() {
		assertTrue(service.updateAppointmentDate("1234567890", LocalDate.of(2027, 10, 31)));
		assertEquals(LocalDate.of(2027, 10, 31), service.getAppointment("1234567890").getAppointmentDate());
	}
	
	@Test
	void testUpdateAppointmentPastDateFail(){
		assertFalse(service.updateAppointmentDate("1234567890", LocalDate.of(1999, 1, 1)));
	}
	
	@Test
	void testUpdateAppointmentTodayDateFail(){
		assertFalse(service.updateAppointmentDate("1234567890", LocalDate.now()));
	}
	
	@Test
	void testUpdateAppointmentNullDateFail(){
		try {
			service.updateAppointmentDate("1234567890", null);
		}
		catch(Exception e) {
			// success
		}
	}
	
	@Test
	void testUpdateAppointmentDateNullIdFail(){
		try {
			service.updateAppointmentDate(null, LocalDate.of(2027, 10, 31));
		}
		catch(Exception e) {
			// success
		}
	}
	
	@Test
	void testUpdateAppointmentDescription() {
		assertTrue(service.updateAppointmentDescription("1234567890", "New Appointment Description"));
		assertEquals("New Appointment Description", service.getAppointment("1234567890").getAppointmentDescription());
	}
	
	@Test
	void testUpdateAppointmentDescriptionLengthFail() {
		assertFalse(service.updateAppointmentDescription("1234567890", "Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus ex sapien vitae pellentesque sem placerat in id cursus mi pretium tellus duis convallis tempus leo eu aenean sed diam urna tempor pulvinar vivamus fringilla lacus nec metus bibendum egestas iaculis massa nisl malesuada lacinia integer nunc posuere ut hendrerit."));
	}
	
	@Test
	void testUpdateAppointmentDescriptionNullFail() {
		try {
			service.updateAppointmentDescription("1234567890", null);
		}
		catch(Exception e) {
			// success
		}
	}
	
	@Test
	void testUpdateAppointmentDescriptionNullIdFail() {
		try {
			service.updateAppointmentDescription(null, "This should throw an error.");
		}
		catch(Exception e) {
			// success
		}
	}
}
