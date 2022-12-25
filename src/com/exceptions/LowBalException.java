package com.exceptions;

public class LowBalException extends Exception {
	private String msg;
	
	public LowBalException(String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		return ""+msg;
	}
}
