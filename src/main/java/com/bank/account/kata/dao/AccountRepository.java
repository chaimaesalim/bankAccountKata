package com.bank.account.kata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.account.kata.format.Account;

public interface AccountRepository extends JpaRepository<Account, String>  {

}
