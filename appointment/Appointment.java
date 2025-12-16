package com.appointment;

import java.time.LocalDate;

public class Appointment {
	private String appointmentId;
	private LocalDate appointmentDate;
	private String appointmentDescription;
	
	// Creates a new instance of Appointment
	public Appointment(String appointmentId, LocalDate appointmentDate, String appointmentDescription) {
		// Throws an exception if appointment ID is null, or more than 10 characters
		if (appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Invalid appointment ID");
		}
		
		// Gets today's date
		LocalDate today = LocalDate.now();
		
		// Throws an exception if appointmentDate is null or is not after today's date
		if (appointmentDate == null || !appointmentDate.isAfter(today)) {
			throw new IllegalArgumentException("Invalid appointment Date");
		}
		
		// Throws an exception if appointmentDescription is null or more than 50 characters
		if (appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid appointment description");
		}
		
		// Sets this instances variables
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentDescription = appointmentDescription;
	}
	
	// Gets and returns appointment ID if it exists
	public String getAppointmentId() {
		return this.appointmentId;
	}
	
	// Gets and returns appointment date if it exists
	public LocalDate getAppointmentDate() {
		return this.appointmentDate;
	}
	
	// Sets appointment date
	public void setAppointmentDate(LocalDate newDate) {
		// Gets today's date
		LocalDate today = LocalDate.now();
		// Throws an exception if appointmentDate is null or is not after today's date
		if (newDate == null || !newDate.isAfter(today)) {
			throw new IllegalArgumentException("Invalid appointment Date");
		}
		// Sets date
		this.appointmentDate = newDate;
	}
	
	// Gets and returns appointment description if it exists
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
	
	// Sets appointment description
	public void setAppointmentDescription(String newDesc) {
		// Throws an exception if appointmentDescription is null or more than 50 characters
		if (newDesc == null || newDesc.length() > 50) {
			throw new IllegalArgumentException("Invalid appointment description");
		}
		// sets description
		this.appointmentDescription = newDesc;
	}
}
