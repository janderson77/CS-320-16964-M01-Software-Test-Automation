package com.task.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.contact.Contact;
import com.contact.ContactService;
import com.task.Task;

public class TaskTest {
	@Test
	void testValidTaskCreation() {
		Task task = new Task("1234567890", "New Task", "This is the description for the task.");
		assertEquals("1234567890", task.getTaskId());
		assertEquals("New Task", task.getTaskName());
		assertEquals("This is the description for the task.", task.getTaskDescription());
	}
	
	@Test
	void testInvalidTaskId() {
		try {
			new Task(null, "New Task", "This is the description for the task.");
		}
		catch(Exception e) {
			// success
		}
		
		try {
			new Task("123456789012345674890", "New Task", "This is the description for the task.");
		}
		catch(Exception e) {
			// success
		}
	}
	
	@Test
	void testInvalidTaskName() {
		try {
			new Task("1234567890", null, "This is the description for the task.");
		}
		catch(Exception e) {
			// success
		}
		
		try {
			new Task("1234567890", "New TaskNew TaskNew TaskNew TaskNew TaskNew Task", "This is the description for the task.");
		}
		catch(Exception e) {
			// success
		}
	}
	
	@Test
	void testInvalidTaskDescription() {
		try {
			new Task("1234567890", "New Task", null);
		}
		catch(Exception e) {
			// success
		}
		
		try {
			new Task("1234567890", "New Task", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam orci sapien, interdum sed malesuada eget, pulvinar non massa. Duis rhoncus venenatis libero sit amet mattis. Sed interdum tincidunt orci ut facilisis. Suspendisse tempus lorem eget hendrerit aliquet. Suspendisse vitae risus tortor. Quisque fermentum commodo augue nec dignissim. Ut eu ligula at enim vehicula gravida. Donec in porta felis. Fusce iaculis metus in enim iaculis, sit amet venenatis nisl ultrices.");
		}
		catch(Exception e) {
			// success
		}
	}
	
	@Test
	void testSetters() {
		Task task = new Task("1234567890", "New Task", "This is the description for the task.");
		task.setTaskName("Task1");
		task.setTaskDescription("Task 1 description");
		assertEquals("Task1", task.getTaskName());
		assertEquals("Task 1 description", task.getTaskDescription());
	}
	
	@Test
	void testSettersValidateInput() {
		Task task = new Task("1234567890", "New Task", "This is the description for the task.");
		
		try {
			task.setTaskName(null);
		}
		catch(Exception e) {
			// success
		}
		
		try {
			task.setTaskName("This is an invalid task name and won't work");
		}
		catch(Exception e) {
			// success
		}
		
		try {
			task.setTaskDescription(null);		}
		catch(Exception e) {
			// success
		}
		
		try {
			task.setTaskName("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam orci sapien, interdum sed malesuada eget, pulvinar non massa. Duis rhoncus venenatis libero sit amet mattis. Sed interdum tincidunt orci ut facilisis. Suspendisse tempus lorem eget hendrerit aliquet. Suspendisse vitae risus tortor. Quisque fermentum commodo augue nec dignissim. Ut eu ligula at enim vehicula gravida. Donec in porta felis. Fusce iaculis metus in enim iaculis, sit amet venenatis nisl ultrices.");
		}
		catch(Exception e) {
			// success
		}
	}
	
	@Test
	void testGetters() {
		Task task = new Task("1234567890", "New Task", "This is the description for the task.");
		assertEquals("New Task", task.getTaskName());
		assertEquals("This is the description for the task.", task.getTaskDescription());
	}
}
