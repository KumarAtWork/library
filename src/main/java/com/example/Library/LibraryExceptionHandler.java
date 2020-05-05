package com.example.Library;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LibraryExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleLibraryNotFoundException(ResourceNotFoundException request){
		Map<String,String> object = new LinkedHashMap<>();
		object.put("message", request.getMessage());
		return new ResponseEntity<Object>(object, HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object> handleBadRequestException(BadRequestException request){
		Map<String,String> object = new LinkedHashMap<>();
		object.put("message", request.getMessage());
		return new ResponseEntity<Object>(object, HttpStatus.BAD_REQUEST); 
	}
}
