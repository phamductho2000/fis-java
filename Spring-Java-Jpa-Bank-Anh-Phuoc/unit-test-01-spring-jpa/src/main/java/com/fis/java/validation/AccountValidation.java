package com.fis.java.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fis.java.repo.AccountRepo;
import com.fis.java.service.AccountService;
import static com.fis.java.constant.SystemConstant.*;

@Component
public class AccountValidation {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	AccountRepo accountRepo;
	
	public boolean checkAccountNumberAccepted(String accountNumber) {
		boolean isExist = accountService.findAll().stream()
				.anyMatch(s -> s.getAccountNumber().equals(accountNumber));
		if (accountNumber.length() == 12 && isExist == false)
			return true;

		return false;
	}
	
	public boolean checkAccountNameAccepted(String accountName) {
		return accountName.length() > 5 && accountName.length() < 100;
	}
	
	public boolean isAccountIdExist(long id) {
		return accountService.findAll().stream()
				.anyMatch(s -> s.getAccountId() == id);
	}
	
	public boolean checkStatusAccountAccepted(int status) {
		return status == HET_HIEU_LUC || status == HIEU_LUC || status == TAM_KHOA;
	}
	
	public boolean checkStatus1FromAccountNumber(String accountNumber) {
		return accountService.findAll().stream()
				.filter(s -> s.getAccountNumber().equals(accountNumber))
				.anyMatch(s -> s.getStatus() == HIEU_LUC);
	}
}
