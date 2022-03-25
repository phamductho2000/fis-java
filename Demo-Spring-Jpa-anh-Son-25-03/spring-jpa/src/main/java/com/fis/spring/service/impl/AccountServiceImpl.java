package com.fis.spring.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.spring.dao.AccountDao;
import com.fis.spring.entity.Account;
import com.fis.spring.repo.AccountRepo;
import com.fis.spring.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepo accountRepo;

	@Override
	public Account save(Account account) {
		account.setIssuedDate(new Date());
		return accountRepo.save(account);
	}

	@Override
	public Account update(Account account) {
		account.setUpdateDate(new Date());
		return accountRepo.save(account);
	}

	@Override
	public void deleteById(Long accountId) {
		accountRepo.deleteById(accountId);
	}

	@Override
	public Account getById(Long accountId) {
		return accountRepo.getById(accountId);
	}

	@Override
	public List<Account> getByFullname(String fullname) {
		return accountRepo.getByFullname(fullname);
	}

}
