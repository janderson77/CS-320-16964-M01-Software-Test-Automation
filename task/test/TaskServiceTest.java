package com.task.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.task.Task;
import com.task.TaskService;

public class TaskServiceTest {
	private TaskService service;
	
	@BeforeEach
	void setUp() {
		service = new TaskService();
		service.addTask(new Task("1234567890", "Task Name", "This is the task description"));
	}
	
	@Test
	void testAddTaskSuccess() {
		assertTrue(service.addTask(new Task("2234567890", "Second Task", "This is also the task description")));
	}
	
	@Test
	void testAddTaskDuplicateIDFail() {
		assertFalse(service.addTask(new Task("1234567890", "BadTask", "This should return false")));
	}
	
	@Test
	void testAddTaskNullIDFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(new Task(null, "BadTask", "This should fail"));
		});
	}
	
	@Test
	void testAddTaskIDLengthFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(new Task("12345678910", "BadTask", "This should fail"));
		});
	}
	
	@Test
	void testAddTaskNullTaskNameFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(new Task("123456789", null, "This should fail"));
		});
	}
	
	@Test
	void testAddTaskNameLengthFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(new Task("123456789", "1234567891012345678910", "This should fail"));
		});
	}
	
	@Test
	void testAddTaskNullDescriptionFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(new Task("123456789", "BadTask", null));
		});
	}
	
	@Test
	void testAddTaskTaskDescriptionLengthFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(new Task("123456789", "1234567890", "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"));
		});
	}
	
	@Test
	void testDeleteTask() {
		assertTrue(service.removeTask("1234567890"));
		assertNull(service.getTask("1234567890"));
	}
	
	@Test
	void testDeleteTaskNoTaskFail() {
		assertFalse(service.removeTask("9999999999"));
	}
	
	@Test
	void testDeleteTaskNullIdFail() {
		assertFalse(service.removeTask(null));
	}
	
	@Test
	void testUpdateTaskName() {
		assertTrue(service.updateTaskName("1234567890", "First Task"));
		assertEquals("First Task", service.getTask("1234567890").getTaskName());
	}
	
	@Test
	void testUpdateTaskNameNullIdFail() {
		assertFalse(service.updateTaskName(null, "1234567890"));
	}
	
	@Test
	void testUpdateTaskNameNullNameFail() {
		assertFalse(service.updateTaskName("123456789", null));
	}
	
	@Test
	void testUpdateTaskNameLengthFail() {
		assertFalse(service.updateTaskName("123456789", "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"));
	}
	
	@Test
	void testUpdateTaskNameNoTaskFail() {
		assertFalse(service.updateTaskName("9999999999", "This should fail"));
	}
	
	@Test
	void testUpdateTaskDescription() {
		assertTrue(service.updateTaskDescription("1234567890", "New task description"));
		assertEquals("New task description", service.getTask("1234567890").getTaskDescription());
	}
	
	@Test
	void testUpdateTaskDescriptionNullIdFail() {
		assertFalse(service.updateTaskDescription(null, "This should fail"));
	}
	
	@Test
	void testUpdateTaskDescriptionNullFail() {
		assertFalse(service.updateTaskDescription("123456789", null));
	}
	
	@Test
	void testUpdateTaskDescriptionLengthFail() {
		assertFalse(service.updateTaskDescription("123456789", "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"));
	}
	
	@Test
	void testUpdateTaskDescriptionNoTaskFail() {
		assertFalse(service.updateTaskDescription("9999999999", "This should fail"));
	}
}
