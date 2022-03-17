package fis.java.banking;

import java.util.Date;

public class TransactionHistory {
	private long accountNumber;
	private double balance;
	private Date date;
	private double amount;
	private String detail;
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "TransactionHistory [balance=" + balance + ", date=" + date + ", amount=" + amount + ", detail=" + detail
				+ "]";
	}
	
	
	
}
