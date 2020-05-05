package com.example.Library;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(long id) {
		
		super("Resource not found with id:"+id);
	}

}
