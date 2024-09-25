package com.ibm.spring_boot_simple_project.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdNotFoundException  extends  RuntimeException{

	String message;
	public IdNotFoundException(String message) {
		super(message);
		this.message=message;
	}
}
