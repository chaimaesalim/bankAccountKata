package com.bank.account.kata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bank.account.kata.dao.AccountRepository;
import com.bank.account.kata.dao.TransactionRepository;
import com.bank.account.kata.format.Account;
import com.bank.account.kata.format.Transaction;

@SpringBootApplication
public class BankAccountKata1Application implements CommandLineRunner{
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepo;
	public static void main(String[] args) {
		SpringApplication.run(BankAccountKata1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Account acount1=new Account(100000, "CPT00000111");
		Account acount2=new Account(258, "CPT00000112");
		Account acount3=new Account(226310000, "CPT00000113");
		accountRepository.save(acount1);
		accountRepository.save(acount2);
		accountRepository.save(acount3);
		Transaction tr1Cpt1=new Transaction();
//		Transaction tr1Cpt2=new Transaction();
//		Transaction tr1Cpt3=new Transaction();
//		Transaction tr2Cpt1=new Transaction();
//		Transaction tr3Cpt1=new Transaction();
//		Transaction tr2Cpt3=new Transaction();
		tr1Cpt1.setAccount(acount1);
		tr1Cpt1.setAmount(105);
		tr1Cpt1.setBalanceAfterTransaction(100000);
		transactionRepo.save(tr1Cpt1);
	}

}
