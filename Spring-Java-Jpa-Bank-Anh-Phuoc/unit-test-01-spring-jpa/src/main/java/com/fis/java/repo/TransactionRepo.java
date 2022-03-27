package com.fis.java.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fis.java.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	@Query("SELECT t FROM Transaction t WHERE t.fromAccount.accountNumber = ?1 AND t.toAccount.accountNumber = ?2")
	List<Transaction> findTransaction(String fromAccountNumber, String toAccountNUmber);

	@Query("SELECT t FROM Transaction t WHERE t.fromAccount.accountNumber = ?1 AND t.toAccount.accountNumber = ?2 AND t.amount = ?3")
	List<Transaction> findTransaction(String fromAccountNumber, String toAccountNUmber, double amount);
	
	@Query("SELECT t FROM Transaction t WHERE t.fromAccount.accountNumber = ?1 AND t.toAccount.accountNumber = ?2 AND t.content LIKE %?3%")
	List<Transaction> findTransaction(String fromAccountNumber, String toAccountNUmber, String content);

	@Query("SELECT t FROM Transaction t WHERE t.fromAccount.accountNumber = ?1 AND t.toAccount.accountNumber = ?2 AND t.amount = ?3 AND t.content LIKE %?4%")
	List<Transaction> findTransaction(String fromAccountNumber, String toAccountNUmber, double amount, String content);
}
