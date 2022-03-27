package com.fis.java.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.java.dto.FormTransactionDTO;
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

	@Override
	public List<Transaction> findAll() {
		return transactionRepo.findAll();
	}

	@Override
	public Transaction findById(Long id) {
		Optional<Transaction> foundedTransaction = transactionRepo.findById(id);
		return foundedTransaction.isPresent() ? foundedTransaction.get() : null;
	}

	@Override
	public List<Transaction> findTransaction(FormTransactionDTO transactionDTO) {
		if(!transactionDTO.getFromAccountNumber().isEmpty() && !transactionDTO.getToAccountNumber().isEmpty()) {
			if((Double) transactionDTO.getAmount() != null && transactionDTO.getContent().isEmpty()) {
				return findTransaction(transactionDTO.getFromAccountNumber(), transactionDTO.getToAccountNumber(),  transactionDTO.getAmount());
			}
			else if((Double) transactionDTO.getAmount() == null && !transactionDTO.getContent().isEmpty()) {
				return findTransaction(transactionDTO.getFromAccountNumber(), transactionDTO.getToAccountNumber(),  transactionDTO.getContent());
			}
			else if((Double) transactionDTO.getAmount() == null && transactionDTO.getContent().isEmpty()) {
				return findTransaction(transactionDTO.getFromAccountNumber(), transactionDTO.getToAccountNumber());
			}
			else {
				return findTransaction(transactionDTO.getFromAccountNumber(), transactionDTO.getToAccountNumber(), transactionDTO.getAmount(), transactionDTO.getContent());
			}
		}
		return null;
	}

	@Override
	public List<Transaction> findTransaction(String fromAccountNumber, String toAccountNumber) {
		return transactionRepo.findTransaction(fromAccountNumber, toAccountNumber);
	}

	@Override
	public List<Transaction> findTransaction(String fromAccountNumber, String toAccountNUmber, double amount) {
		return transactionRepo.findTransaction(fromAccountNumber, toAccountNUmber, amount);
	}

	@Override
	public List<Transaction> findTransaction(String fromAccountNumber, String toAccountNUmber, double amount,
			String content) {
		return transactionRepo.findTransaction(fromAccountNumber, toAccountNUmber, amount, content);
	}

	@Override
	public List<Transaction> findTransaction(String fromAccountNumber, String toAccountNUmber, String content) {
		return transactionRepo.findTransaction(fromAccountNumber, toAccountNUmber, content);
	}

}
