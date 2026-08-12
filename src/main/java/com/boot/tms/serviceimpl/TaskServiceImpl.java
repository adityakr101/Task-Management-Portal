package com.boot.tms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boot.tms.exceptions.NoTasksFoundException;
import com.boot.tms.exceptions.TaskNotFoundByIdException;
import com.boot.tms.model.Task;
import com.boot.tms.repository.TaskRepository;
import com.boot.tms.service.TaskService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{
	
	private final TaskRepository repository;

	@Override
	public Task createTask(Task task) {
		return repository.save(task);
	}

	@Override
	public Task updateTaskById(int taskId, Task updatedTask) {
		 Optional<Task> optional=repository.findById(taskId);
		

		if(optional.isEmpty()) {
			throw new TaskNotFoundByIdException("Task Not Found");
		}
		else {
			Task existingTask=optional.get();
			updatedTask.setId(existingTask.getId());
			return repository.save(updatedTask);
		}
	}

	@Override
	public Task getTaskById(int taskId) {
		Optional<Task> optional=repository.findById(taskId);
		
		if(optional.isEmpty()) {
			throw new TaskNotFoundByIdException("Task Not Found");
		}
		else {
			Task existingTask=optional.get();
			return existingTask;
		}
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> existingTasks=repository.findAll();
		
		if(existingTasks.isEmpty()) {
			throw new NoTasksFoundException("Task Not Found");
		}
		else {
			return existingTasks;
		}
	}

	@Override
	public Task removeTaskById(int taskId) {
		Optional<Task> optional=repository.findById(taskId);
		
		if(optional.isEmpty()) {
			throw new TaskNotFoundByIdException("Task Not Found");
		}
		else {
			Task existingTask=optional.get();
			repository.delete(existingTask);
			return existingTask;
		}
	}

	

}
