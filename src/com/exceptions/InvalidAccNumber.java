package com.exceptions;

public class InvalidAccNumber extends Exception{
	private String msg;
	
	public InvalidAccNumber(String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		return ""+msg;
	}
}
