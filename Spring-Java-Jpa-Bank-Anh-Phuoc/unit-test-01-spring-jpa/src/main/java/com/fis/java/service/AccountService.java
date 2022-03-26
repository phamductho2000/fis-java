package com.fis.java.service;

import java.util.List;

import com.fis.java.entity.Account;
import com.fis.java.exception.BankTransactionException;

public interface AccountService {
	Account save(Account account);
	
	Account update(Account account);
	
	void deleteById(Long id);
	
	Account findById(Long id);
	
	List<Account> findAll();

	void sendMoney(String fromAccountNumber, String toAccountNumber, double amount) throws BankTransactionException;

	Account findByAccountNumber(String accountNumber);
	
}
