package com.luv2code.springdemo.ExceotionHandle;

public class ThrowCustomerExcpetion extends RuntimeException{

	public ThrowCustomerExcpetion(String message, Throwable cause) {
		super(message, cause);
	}

	public ThrowCustomerExcpetion(String message) {
		super(message);
	}

	public ThrowCustomerExcpetion(Throwable cause) {
		super(cause);
	}

	
}
