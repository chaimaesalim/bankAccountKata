package com.bank.account.kata.format;

import java.util.Date;

public class Statement {
	private Date date;
	private Double amount;
	private String transactionType;
	private Double balance;
	
	public Statement(Date date, Double amount, String transactionType, Double balance) {
		super();
		this.date = date;
		this.amount = amount;
		this.transactionType = transactionType;
		this.balance = balance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}
