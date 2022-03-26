package com.fis.java.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.fis.java.constant.SystemConstant.*;
import com.fis.java.entity.Account;
import com.fis.java.exception.BankTransactionException;
import com.fis.java.repo.AccountRepo;
import com.fis.java.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepo accountRepo;

	@Override
	public Account save(Account account) {
		return accountRepo.save(account);
	}

	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		Account foundedAccount = findById(id);
		foundedAccount.setStatus(TAM_KHOA);
		accountRepo.save(foundedAccount);
	}

	@Override
	public Account findById(Long id) {
		Optional<Account> foundedAccount = accountRepo.findById(id);
		return foundedAccount.isPresent() ? foundedAccount.get() : null;
	}
	
	@Override
	public Account findByAccountNumber(String accountNumber) {
		return accountRepo.findByAccountNumber(accountNumber);
	}

	@Override
	public List<Account> findAll() {
		return accountRepo.findAll();
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void addAmount(String accountNumber, double amount) throws BankTransactionException {
		Account account = findByAccountNumber(accountNumber);
		if (account == null) {
			throw new BankTransactionException("Khong tim thay tai khoan voi STK = " + accountNumber);
		}
		if(account.getStatus() != HIEU_LUC) {
			throw new BankTransactionException("Tai khoan phai co trang thai hieu luc ");
		}
		if(account.getBalance() + amount < 0) {
			throw new BankTransactionException(String.format("Tai khoan voi STK %s khong du tien de thuc hien giao dich", accountNumber));
		}
		double newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);
		update(account);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = BankTransactionException.class)
	public void sendMoney(String fromAccountNumber, String toAccountNumber, double amount) throws BankTransactionException {

		addAmount(toAccountNumber, amount);
		addAmount(fromAccountNumber, -amount);
	}
}
