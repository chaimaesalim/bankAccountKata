package com.bank.account.kata.services;

import com.bank.account.kata.core.FunctionalException;
import com.bank.account.kata.format.Transaction;

public interface IBankAcountTransaction {
	
	public Transaction deposit(String account, double ammount) throws FunctionalException;
	public Transaction withdrawal(String account, double ammount) throws FunctionalException;
	
}
