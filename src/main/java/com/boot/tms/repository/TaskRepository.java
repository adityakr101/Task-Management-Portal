package com.boot.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.tms.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
	
//	List<Task> findByUserId(int userId);

}
