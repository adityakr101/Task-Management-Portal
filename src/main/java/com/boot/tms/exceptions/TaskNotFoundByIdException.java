package com.boot.tms.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TaskNotFoundByIdException extends RuntimeException {
	
	private String message;

}
