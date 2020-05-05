package com.example.Library;

public class BadRequestException extends RuntimeException{
	
	public BadRequestException() {
		super("Bad request");
	}

}
