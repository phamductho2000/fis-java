package com.fis.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.java.entity.Transaction;
import com.fis.java.repo.TransactionRepo;
import com.fis.java.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepo transactionRepo;
	
	@Override
	public Transaction save(Transaction transaction) {
		return transactionRepo.save(transaction);
	}

}
