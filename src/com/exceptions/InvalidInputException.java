package com.exceptions;

public class InvalidInputException extends Exception {
	private String msg;
	
	public InvalidInputException(String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		return ""+msg;
	}
}
