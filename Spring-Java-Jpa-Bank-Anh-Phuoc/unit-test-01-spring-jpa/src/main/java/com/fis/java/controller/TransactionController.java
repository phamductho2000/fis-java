package com.fis.java.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.java.entity.Transaction;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@PostMapping("/makeTransaction")
	public String makeTransaction(@RequestBody Transaction transaction) {
		return null;
	}
}
