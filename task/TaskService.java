package com.task;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
	// Creates HashMap for storing tasks
	private Map<String, Task> tasks = new HashMap<>();
	
	// Adds a new task to the task HashMap
	public boolean addTask(Task task) {
		// Returns false if a task with the same taskId already exists
		if (tasks.containsKey(task.getTaskId())) {
			return false;
		}
		
		tasks.put(task.getTaskId(), task);
		return true;
	}
	
	// Returns the requested task
	public Task getTask(String taskId) {
		return tasks.get(taskId);
	}
	
	// Removes a task
	public boolean removeTask(String taskId) {
		return tasks.remove(taskId) != null;
	}
	
	// Updates the name of a task
	public boolean updateTaskName(String taskId, String taskName) {
		// Gets the task by ID
		Task task = tasks.get(taskId);
		// Returns false if task is not found.
		if (task == null) return false;
		
		// Updates task name and returns true
		task.setTaskName(taskName);
		return true;
	}
	
	// Updates description of task
	public boolean updateTaskDescription(String taskId, String taskDescription) {
		// Gets the task by ID
		Task task = tasks.get(taskId);
		// returns false if task is not found
		if (task == null) return false;
		
		// Updates task description and returns true
		task.setTaskDescription(taskDescription);
		return true;
	}
}
