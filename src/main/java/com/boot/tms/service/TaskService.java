package com.boot.tms.service;

import java.util.List;

import com.boot.tms.model.Task;

public interface TaskService {

	Task createTask(Task task);

	Task updateTaskById(int taskId, Task updatedTask);

	Task getTaskById(int taskId);

	List<Task> getAllTasks();

	Task removeTaskById(int taskId);
	
    



}
