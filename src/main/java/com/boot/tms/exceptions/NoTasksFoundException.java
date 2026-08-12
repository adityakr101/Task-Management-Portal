package com.boot.tms.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NoTasksFoundException extends RuntimeException {
	
	private String message;

}
