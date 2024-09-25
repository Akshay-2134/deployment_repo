package com.ibm.spring_boot_simple_project.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameNotFoundException extends RuntimeException {
	
	String message;
	public NameNotFoundException(String message) {
		super();
		this.message=message;
	}
}
