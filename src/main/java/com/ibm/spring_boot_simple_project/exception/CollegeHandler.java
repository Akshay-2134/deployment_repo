package com.ibm.spring_boot_simple_project.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.spring_boot_simple_project.response.ResponseStructure;

@ControllerAdvice
public class CollegeHandler {

	@Autowired
	ResponseStructure<String> rs;
	
	@ExceptionHandler(value = NameNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> nameNotFoundException(NameNotFoundException e){
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("");
		rs.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(IdNotFoundException e){
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("");
		rs.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.NOT_FOUND);
	}
}
