package com.fis.java.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.java.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{
	Account findByAccountNumber(String accountNumber);
}
