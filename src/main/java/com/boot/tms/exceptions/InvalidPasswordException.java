package com.boot.tms.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidPasswordException extends RuntimeException {
	
	private String message;

}
