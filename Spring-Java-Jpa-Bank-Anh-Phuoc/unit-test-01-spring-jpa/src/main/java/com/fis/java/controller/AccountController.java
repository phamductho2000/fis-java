package com.fis.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import static com.fis.java.constant.SystemConstant.*;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fis.java.dto.FormTransactionDTO;
import com.fis.java.entity.Account;
import com.fis.java.entity.Transaction;
import com.fis.java.exception.BankTransactionException;
import com.fis.java.service.AccountService;
import com.fis.java.service.TransactionService;
import com.fis.java.validation.AccountValidation;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@Autowired
	TransactionService transactionService;
	
	@Autowired
	AccountValidation accountValidation;

	@PostMapping("/save")
	public ResponseEntity<?> addAccount(@RequestBody Account account) {
		if(!accountValidation.checkAccountNumberAccepted(account.getAccountNumber())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("STK phai la 12 ky tu va khong duoc trung");
		}
		if(!accountValidation.checkAccountNameAccepted(account.getAccountName())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ten tai khoan phai > 5 va < 100 ky tu");
		}
		return ResponseEntity.ok(accountService.save(account));
	}
	
//	@PostMapping("/update")
//	public ResponseEntity<?> updateAccount(@RequestBody Account account) {
//		return ResponseEntity.ok(accountService.save(account));
//	}

	@GetMapping("/delete/{id}")
	public String deleteAccount(@PathVariable Long id) {
		accountService.deleteById(id);
		return "Done!";
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllAccount() {
		return ResponseEntity.ok(accountService.findAll());
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return ResponseEntity.ok(accountService.findById(id));
	}
	
	@GetMapping("/getByNumber/{accountNumber}")
	public ResponseEntity<?> getById(@PathVariable String accountNumber) {
		return ResponseEntity.ok(accountService.findByAccountNumber(accountNumber));
	}

	@PostMapping("/makeTransaction")
	public String makeTransaction(@RequestBody String transaction) throws JsonMappingException, JsonProcessingException {
		String message = "";
		Transaction newTransaction = new Transaction();
		ObjectMapper objectMapper = new ObjectMapper();
		FormTransactionDTO transactionDTO = objectMapper.readValue(transaction, FormTransactionDTO.class);
		
		newTransaction.setFromAccount(accountService.findByAccountNumber(transactionDTO.getFromAccountNumber()));
		newTransaction.setToAccount(accountService.findByAccountNumber(transactionDTO.getToAccountNumber()));
		newTransaction.setAmount(transactionDTO.getAmount());
		newTransaction.setContent(transactionDTO.getContent());
		newTransaction.setTransactionDate(new Date());
		
		try {
			accountService.sendMoney(transactionDTO.getFromAccountNumber(),
					transactionDTO.getToAccountNumber(), transactionDTO.getAmount());
			newTransaction.setStatus(GIAO_DICH_THANH_CONG);
			transactionService.save(newTransaction);
			message = "Giao dich thanh cong";
		} catch (BankTransactionException e) {
			newTransaction.setStatus(GIAO_DICH_THAT_BAI);
			newTransaction.setErrorReason(e.getMessage());
			transactionService.save(newTransaction);
			message = "Giao dich that bai";
		}
		return message;
	}

}
