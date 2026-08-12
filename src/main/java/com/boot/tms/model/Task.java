package com.boot.tms.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tasks")
@Data
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	 private String title;

	 private String description;

	 private String priority;

	 private LocalDate dueDate;

	 private String status;
	 
	 @CreationTimestamp
	 private LocalDateTime createdAt;
	 
	 @UpdateTimestamp
	 private LocalDateTime updatedAt;
	 
	 @ManyToOne
	 @JoinColumn
	 private User user;

}
