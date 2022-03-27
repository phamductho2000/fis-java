package com.fis.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fis.java.dto.FormTransactionDTO;
import com.fis.java.entity.Transaction;
import com.fis.java.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;

	@GetMapping("/findAll")
	public ResponseEntity<?> findAllTransaction() {
		return ResponseEntity.ok(transactionService.findAll());
	}
	
	@PostMapping("/findByFromAndToAccountNumber")
	public ResponseEntity<?> findTransactionByFromAndToAccountNumber(@RequestBody String data) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		FormTransactionDTO transactionDTO = objectMapper.readValue(data, FormTransactionDTO.class);
		return ResponseEntity.ok(transactionService.findTransaction(transactionDTO.getFromAccountNumber(), transactionDTO.getToAccountNumber()));
	}
}
