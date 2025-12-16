package com.task;

public class Task {
	private String taskId;
	private String taskName;
	private String taskDescription;
	
	public Task(String taskId, String taskName, String taskDescription) {
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid task ID");
		}
		
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid task name");
		}
		
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid task description");
		}
		
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
	}
	
	public String getTaskId() {
		return this.taskId;
	}
	
	public String getTaskName() {
		return this.taskName;
	}
	
	public void setTaskName(String newTaskName) {
		if (newTaskName != null && newTaskName.length() <= 10) {
			this.taskName = newTaskName;
		}
		else {
			throw new IllegalArgumentException("Invalid entry for task name");
		}
	}
	
	public String getTaskDescription() {
		return this.taskDescription;
	}
	
	public void setTaskDescription(String newDescription) {
		if (newDescription != null && newDescription.length() <= 50) {
			this.taskDescription = newDescription;
		}
		else {
			throw new IllegalArgumentException("Invalid entry for description");
		}
	}
}
