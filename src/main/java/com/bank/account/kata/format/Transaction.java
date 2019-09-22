package com.bank.account.kata.format;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Transaction {
	@Id
	@GeneratedValue
	private Long tansactionId;
	private Date date;
	private double amount;
	private String transactionType;
	@ManyToOne
	@JoinColumn(name="CODE_CPT")
	private Account account;
	private double balanceAfterTransaction;
	
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public double getBalanceAfterTransaction() {
		return balanceAfterTransaction;
	}
	public void setBalanceAfterTransaction(double balanceAfterTransaction) {
		this.balanceAfterTransaction = balanceAfterTransaction;
	}
	
	public Transaction() {
	}
	public Transaction(Long tansactionId, Date date, double amount,String transactionType,double balanceAfterTransaction) {
		this.tansactionId = tansactionId;
		this.date = date;
		this.amount = amount;
		this.transactionType= transactionType;
		this.balanceAfterTransaction=balanceAfterTransaction;
	}
	public Long getTansactionId() {
		return tansactionId;
	}
	public void setTansactionId(Long tansactionId) {
		this.tansactionId = tansactionId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
}
