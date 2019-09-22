package com.bank.account.kata.format;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {

	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	private double balance;
	@Id
	private String accountId;
	@OneToMany(mappedBy="account", fetch=FetchType.LAZY)
	private List<Transaction> transactions;
	
	public Account() {
	}
	public Account(double balance, String accountId) {
		this.balance = balance;
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
}
