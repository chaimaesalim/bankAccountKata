package com.bank.account.kata.core;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.kata.format.AccountStatement;
import com.bank.account.kata.format.Statement;
import com.bank.account.kata.format.Transaction;
import com.bank.account.kata.services.IBankAccountStatement;
import com.bank.account.kata.services.IBankAcountTransaction;

@RestController
public class BankAccountController {
	
	@Autowired
	private IBankAccountStatement bankAccountStatementServices;
	@Autowired
	private IBankAcountTransaction bankAccountTransactionServices;
	
	@GetMapping(path="/accountStatement")
	public AccountStatement getAccountTransactionHistory(@RequestParam(value="account") String account) throws FunctionalException {
		
		return bankAccountStatementServices.findAllAccountTransactions(account, new Date());
		
	}
	@PostMapping(path="/deposit")
	public Statement deposit(@RequestParam(value="account") String account,@RequestParam(value="amount") double amount) throws FunctionalException {
		
		Transaction transaction=bankAccountTransactionServices.deposit(account, amount);
		return new Statement(transaction.getDate(), transaction.getAmount(), transaction.getTransactionType(), transaction.getBalanceAfterTransaction());

	}
	@PostMapping(path="/withdrawal")
	public Statement withdrawal(@RequestParam(value="account") String account,@RequestParam(value="amount") double amount) throws FunctionalException {
		
		Transaction transaction=bankAccountTransactionServices.withdrawal(account, amount);
		return new Statement(transaction.getDate(), transaction.getAmount(), transaction.getTransactionType(), transaction.getBalanceAfterTransaction());

	}
	
	
}
