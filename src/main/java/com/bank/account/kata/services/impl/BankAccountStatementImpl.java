package com.bank.account.kata.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.account.kata.core.FunctionalException;
import com.bank.account.kata.dao.TransactionRepository;
import com.bank.account.kata.format.AccountStatement;
import com.bank.account.kata.format.Statement;
import com.bank.account.kata.format.Transaction;
import com.bank.account.kata.services.IBankAccountStatement;
@Service
@Transactional
public class BankAccountStatementImpl implements IBankAccountStatement{
	
	@Autowired
	private TransactionRepository transactionRepo;
	@Override
	public String printStatement(List<Statement> list) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AccountStatement findAllAccountTransactions(String accountId, Date date) throws FunctionalException {
		
		List<Transaction> list = new ArrayList<>();
		try {
			list = transactionRepo.listTransaction(accountId);
		} catch (EntityNotFoundException e) {
			throw new FunctionalException("Account not found");
		}
		List<Statement> statements=new ArrayList<>();
		for (Transaction item : list) {
			Statement stm=new Statement(item.getDate(), item.getAmount(), item.getTransactionType(), item.getBalanceAfterTransaction());
			statements.add(stm);
		}
		return new AccountStatement(statements);
	}

	
	
	
	

}
