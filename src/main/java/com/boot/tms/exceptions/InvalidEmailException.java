package com.boot.tms.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidEmailException extends RuntimeException {
	
	private String message;

}
