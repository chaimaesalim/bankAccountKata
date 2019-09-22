package com.bank.account.kata.format;

import java.util.List;

public class AccountStatement {
	private List<Statement> statements;

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	public AccountStatement(List<Statement> statements) {
		this.statements = statements;
	}
	
}
