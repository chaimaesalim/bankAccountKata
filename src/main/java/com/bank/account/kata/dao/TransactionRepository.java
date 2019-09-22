package com.bank.account.kata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.account.kata.core.FunctionalException;
import com.bank.account.kata.format.Transaction;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
		
		@Query("select t from Transaction t where t.account.accountId = :item")
		public List<Transaction> listTransaction(@Param("item")String accountId);
}
