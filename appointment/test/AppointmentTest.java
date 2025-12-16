package com.appointment.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.appointment.Appointment;

public class AppointmentTest {
	@Test
	void testValidAppointmentCreation() {
		Appointment appointment = new Appointment("123456", LocalDate.of(2035, 10, 31), "Appointment Description");
		assertEquals("123456", appointment.getAppointmentId());
		assertEquals(LocalDate.of(2035, 10, 31), appointment.getAppointmentDate());
		assertEquals("Appointment Description", appointment.getAppointmentDescription());
	}
	
	@Test
	void testAppointmentSetters() {
		Appointment appointment = new Appointment("123456", LocalDate.of(2035, 10, 31), "Appointment Description");
		appointment.setAppointmentDate(LocalDate.of(2026, 10, 31));
		assertEquals(LocalDate.of(2026, 10, 31), appointment.getAppointmentDate());
		
		appointment.setAppointmentDescription("This is new.");
		assertEquals("This is new.", appointment.getAppointmentDescription());
	}
	
	@Test
	void testInvalidAppointmentId() {
		try {
			new Appointment(null, LocalDate.of(2035, 10, 31), "Appointment Description");
			fail("Expected IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			//success
		}
		
		try {
			new Appointment("1234567890123", LocalDate.of(2035, 10, 31), "Appointment Description");
			fail("Expected IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			//success
		}
	}
	
	@Test
	void testInvalidAppointmentDate() {
		try {
			new Appointment("123456", null, "Appointment Description");
			fail("Expected IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			//success
		}
		
		try {
			new Appointment("123456", LocalDate.of(2019, 10, 31), "Appointment Description");
			fail("Expected IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			//success
		}
	}
	
	@Test
	void testInvalidAppointmentDescription() {
		try {
			new Appointment("123456", LocalDate.of(2035, 10, 31), null);
			fail("Expected IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			//success
		}
		
		try {
			new Appointment("123456", LocalDate.of(2035, 10, 31), "Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus ex sapien vitae pellentesque sem placerat in id cursus mi pretium tellus duis convallis tempus leo eu aenean sed diam urna tempor pulvinar vivamus fringilla lacus nec metus bibendum egestas iaculis massa nisl malesuada lacinia integer nunc posuere ut hendrerit.");
			fail("Expected IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			//success
		}
	}
	
	@Test
	void testSettersValidateInput() {
		Appointment appointment = new Appointment("123456", LocalDate.of(2035, 10, 31), "Appointment Description");
		
		assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(null));
		assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(LocalDate.of(2022, 10, 31)));
		assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDescription(null));
		assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus ex sapien vitae pellentesque sem placerat in id cursus mi pretium tellus duis convallis tempus leo eu aenean sed diam urna tempor pulvinar vivamus fringilla lacus nec metus bibendum egestas iaculis massa nisl malesuada lacinia integer nunc posuere ut hendrerit."));
		
	}
}
