package com.ibm.spring_boot_simple_project.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseStructure<T> {
	
	private int statusCode;
	private String message;
	private T data;

}
