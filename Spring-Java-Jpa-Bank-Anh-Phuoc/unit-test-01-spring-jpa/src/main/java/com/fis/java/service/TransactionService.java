package com.fis.java.service;

import java.util.List;

import com.fis.java.dto.FormTransactionDTO;
import com.fis.java.entity.Transaction;

public interface TransactionService {
	Transaction save(Transaction transaction);

	List<Transaction> findAll();

	Transaction findById(Long id);

	List<Transaction> findTransaction(String fromAccountNumber, String toAccountNumber);
	
	List<Transaction> findTransaction(String fromAccountNumber, String toAccountNUmber, double amount);
	
	List<Transaction> findTransaction(String fromAccountNumber, String toAccountNUmber, String content);
	
	List<Transaction> findTransaction(String fromAccountNumber, String toAccountNUmber, double amount, String content);

	List<Transaction> findTransaction(FormTransactionDTO transactionDTO);
}
