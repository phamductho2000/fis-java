package com.fis.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FormTransactionDTO {
	private String fromAccountNumber;
	private String toAccountNumber;
	private double amount;
	private String content;
}
