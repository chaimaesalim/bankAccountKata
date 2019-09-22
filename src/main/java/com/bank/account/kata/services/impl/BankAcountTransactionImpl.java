package com.bank.account.kata.services.impl;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.account.kata.core.FunctionalException;
import com.bank.account.kata.dao.AccountRepository;
import com.bank.account.kata.dao.TransactionRepository;
import com.bank.account.kata.format.Account;
import com.bank.account.kata.format.Transaction;
import com.bank.account.kata.services.IBankAcountTransaction;
@Service
@Transactional
public class BankAcountTransactionImpl implements IBankAcountTransaction {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepo;
	
	@Override
	public Transaction deposit(String accountId, double amount) throws FunctionalException {
		
		Account accountToDeposit = new Account();
		Transaction tr = new Transaction();
		try {
			accountToDeposit = accountRepository.getOne(accountId);
		} catch (EntityNotFoundException e) {
			throw new FunctionalException(FunctionalException.CODE_ERROR_ACCOUNT_NOT_FOUND);
		}
		double newBalance;
		try {
			//Deposit
			newBalance = accountToDeposit.getBalance() + amount;
		} catch (EntityNotFoundException e) {
			throw new FunctionalException(FunctionalException.CODE_ERROR_ACCOUNT_NOT_FOUND);
		}
		accountToDeposit.setBalance(newBalance);
		tr.setAccount(accountToDeposit);
		tr.setAmount(amount);
		tr.setDate(new Date());
		tr.setTransactionType("Deposit");
		tr.setBalanceAfterTransaction(newBalance);
		if (accountToDeposit.getTransactions()!=null) {
			accountToDeposit.getTransactions().add(tr);
		}else {
			accountToDeposit.setTransactions(new ArrayList<Transaction>());
			accountToDeposit.getTransactions().add(tr);
		}
		transactionRepo.save(tr);
		accountRepository.save(accountToDeposit);

		return tr;
	}

	@Override
	public Transaction withdrawal(String account, double amount) throws FunctionalException {
		
		Transaction tr=new Transaction();
		Account accountToWithdrawal=new Account();
		try {
			accountToWithdrawal=accountRepository.getOne(account);
		} catch (EntityNotFoundException e) {
			throw new FunctionalException(FunctionalException.CODE_ERROR_ACCOUNT_NOT_FOUND);
		}
		if (accountToWithdrawal.getBalance() < amount) {
			// Withdrawal refused
			throw new FunctionalException(FunctionalException.CODE_ERROR_WITHDRAWAL_REFUSED);
		} else {

			double newBalance;
			try {
				//Withdrawal
				newBalance = accountToWithdrawal.getBalance() - amount;
			} catch (EntityNotFoundException e) {
				throw new FunctionalException(FunctionalException.CODE_ERROR_ACCOUNT_NOT_FOUND);
			}
			accountToWithdrawal.setBalance(newBalance);
			tr.setAccount(accountToWithdrawal);
			tr.setAmount(amount);
			tr.setDate(new Date());
			tr.setTransactionType("Withdrawal");
			tr.setBalanceAfterTransaction(newBalance);
			if (accountToWithdrawal.getTransactions()!=null) {
				accountToWithdrawal.getTransactions().add(tr);
			}else {
				accountToWithdrawal.setTransactions(new ArrayList<Transaction>());
				accountToWithdrawal.getTransactions().add(tr);
			}
			
			transactionRepo.save(tr);
			accountRepository.save(accountToWithdrawal);
		}
		return tr;
	}

}
