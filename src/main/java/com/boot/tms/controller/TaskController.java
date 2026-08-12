package com.boot.tms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.tms.model.Task;
import com.boot.tms.service.TaskService;
import com.boot.tms.util.ResponseStructure;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TaskController {
	
	private final TaskService service;
	
	@PostMapping("/tasks")
	public ResponseEntity<ResponseStructure<Task>> addTask(@RequestBody Task task){
		Task t=service.createTask(task);
		
		ResponseStructure<Task> rs=new ResponseStructure<Task>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("Task object created successfully");
		rs.setData(t);
		
		return new ResponseEntity<ResponseStructure<Task>>(rs,HttpStatus.CREATED);
	}
	
	@PutMapping("/tasks/id/{id}")
	public ResponseEntity<ResponseStructure<Task>> updateTask(@PathVariable("id") int taskId,@RequestBody Task updatedTask) {
		Task t=service.updateTaskById(taskId,updatedTask);
		
		ResponseStructure<Task> rs=new ResponseStructure<Task>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Task object updated successfully");
		rs.setData(t);
		
		return new ResponseEntity<ResponseStructure<Task>>(rs,HttpStatus.OK);
	}
	
	@GetMapping("/tasks/id/{id}")
	public ResponseEntity<ResponseStructure<Task>> displayTaskById(@PathVariable("id") int taskId) {
		Task t=service.getTaskById(taskId);
		
		ResponseStructure<Task> rs=new ResponseStructure<Task>();
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage("Task object found successfully");
		rs.setData(t);
		
		return new ResponseEntity<ResponseStructure<Task>>(rs,HttpStatus.FOUND);
	}
	
	@GetMapping("/tasks")
	public ResponseEntity<ResponseStructure<List<Task>>> displayAllTasks(){
		List<Task> actors=service.getAllTasks();
		
		ResponseStructure<List<Task>> rs=new ResponseStructure<List<Task>>();
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage("Task objects found successfully");
		rs.setData(actors);
		 
		return new ResponseEntity<ResponseStructure<List<Task>>>(rs,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/tasks/id/{id}")
	public ResponseEntity<ResponseStructure<Task>> deleteActorById(@PathVariable("id") int taskId) {
		Task t=service.removeTaskById(taskId);
		
		ResponseStructure<Task> rs=new ResponseStructure<Task>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Task object deleted successfully");
		rs.setData(t);
		
		return new ResponseEntity<ResponseStructure<Task>>(rs,HttpStatus.OK);
	}

}
