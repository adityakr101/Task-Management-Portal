package com.boot.tms.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.boot.tms.exceptions.InvalidEmailException;
import com.boot.tms.exceptions.InvalidPasswordException;
import com.boot.tms.exceptions.NoTasksFoundException;
import com.boot.tms.exceptions.TaskNotFoundByIdException;
import com.boot.tms.util.ErrorStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TaskNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure<String>> handleTaskNotFoundById(TaskNotFoundByIdException ex) {
		
		ErrorStructure<String> es=new ErrorStructure<String>();
		es.setErrorCode(HttpStatus.NOT_FOUND.value());
		es.setErrorMessage(ex.getMessage());
		es.setError("Task with the requested id is not avialable in the database");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoTasksFoundException.class)
	public ResponseEntity<ErrorStructure<String>> handleNoTasksFound(NoTasksFoundException ex) {
		
		ErrorStructure<String> es=new ErrorStructure<String>();
		es.setErrorCode(HttpStatus.NOT_FOUND.value());
		es.setErrorMessage(ex.getMessage());
		es.setError("Task details is not available in the database");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<ErrorStructure<String>> handleInvalidEmail(InvalidEmailException ex) {

	    ErrorStructure<String> es = new ErrorStructure<String>();

	    es.setErrorCode(HttpStatus.UNAUTHORIZED.value());
	    es.setErrorMessage(ex.getMessage());
	    es.setError("Invalid Email");

	    return new ResponseEntity<ErrorStructure<String>>(es, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ErrorStructure<String>> handleInvalidPassword(InvalidPasswordException ex) {

	    ErrorStructure<String> es = new ErrorStructure<String>();

	    es.setErrorCode(HttpStatus.UNAUTHORIZED.value());
	    es.setErrorMessage(ex.getMessage());
	    es.setError("Invalid Password");

	    return new ResponseEntity<ErrorStructure<String>>(es, HttpStatus.UNAUTHORIZED);
	}
}
