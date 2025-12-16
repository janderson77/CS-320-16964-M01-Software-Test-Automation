package com.appointment;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class AppointmentService {
	private Map<String, Appointment> appointments = new HashMap<>();
	
	// Add a new appointment
	public boolean addAppointment(Appointment appointment) {
		// Check if appointment ID is unique
		if (appointments.containsKey(appointment.getAppointmentId())) {
			return false;
		}
		// Add appointment to map
		appointments.put(appointment.getAppointmentId(), appointment);
		return true;
	}
	
	// Removes an appointment if it exists
	public boolean removeAppointment(String appointmentId) {
		return appointments.remove(appointmentId) != null;
	}
	
	// Attempts to update appointment date
	public boolean updateAppointmentDate(String appointmentId, LocalDate newDate) {
		Appointment appointment = appointments.get(appointmentId);
		
		// Returns false if appointment doesn't exist or requested date not after today's date
		if (appointment == null || !newDate.isAfter(LocalDate.now())) {
			return false;
		}
		
		appointment.setAppointmentDate(newDate);
		return true;
	}
	
	// Attempts to update appointment description
	public boolean updateAppointmentDescription(String appointmentId, String newDesc) {
		Appointment appointment = appointments.get(appointmentId);
		
		// Returns false if appointment doesn't exist or new description is > 50 characters
		if (appointment == null || newDesc.length() > 50) {
			return false;
		}
		
		appointment.setAppointmentDescription(newDesc);
		return true;
	}
	
	public Appointment getAppointment(String appointmentId) {
		return appointments.get(appointmentId);
	}
}
