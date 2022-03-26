package com.fis.java.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Long transactionId;
	
	@Column(name = "transaction_date")
	private Date transactionDate;
	
	@Column(name = "transaction_status")
	private int status;
	
	@Column(name = "transaction_content")
	private String content;
	
	@Column(name = "transaction_error")
	private String errorReason;
	
	@Column(name = "transaction_amount")
	private double amount;
	
	@ManyToOne
	@JoinColumn(name = "from_account", nullable = false)
	private Account fromAccount;
	
	@ManyToOne
	@JoinColumn(name = "to_account", nullable = false)
	private Account toAccount;
}
