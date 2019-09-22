package com.bank.account.kata.services;

import java.util.Date;
import java.util.List;

import com.bank.account.kata.core.FunctionalException;
import com.bank.account.kata.format.Account;
import com.bank.account.kata.format.AccountStatement;
import com.bank.account.kata.format.Statement;

public interface IBankAccountStatement{
	
	public String printStatement(List<Statement> list);
	public AccountStatement findAllAccountTransactions(String account, Date date) throws FunctionalException;
}
