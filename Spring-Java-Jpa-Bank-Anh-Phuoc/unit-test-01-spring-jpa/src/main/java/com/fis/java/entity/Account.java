package com.fis.java.entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long accountId;
	
	@Column(name = "account_number")
	private String accountNumber;
	
	@Column(name = "account_name")
	private String accountName;
	
	@Column(name = "balance")
	private double balance;
	
	@Column(name = "status")
	private int status;
	
//	@OneToMany(mappedBy = "toAccount")
//	private List<Transaction> transactions;
	
//	@Column(name = "issued_date")
//	private Date issuedDate;
//	
//	@Column(name = "update_date")
//	private Date updateDate;
}
