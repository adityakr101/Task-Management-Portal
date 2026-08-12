package com.boot.tms.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorStructure<T> {
	
	private int errorCode;
	private String errorMessage;
	private T error;

}
