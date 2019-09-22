package com.bank.account.kata.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FunctionalException extends Exception{
	
	public static final String CODE_ERROR_ACCOUNT_NOT_FOUND="Account not found";
	public static final String CODE_ERROR_WITHDRAWAL_REFUSED="Withdrawal refused, contact your bank";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FunctionalException(String message) {
		super(message);
	}

	

}
