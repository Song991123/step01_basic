package com.ws07.exception;

public class BalanceLackException extends Exception {

	public BalanceLackException() {
		super("잔액이 부족합니다.");
	}

	public BalanceLackException(String message) {
		super(message);
	}
	
}
