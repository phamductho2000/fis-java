package fis.java;

import java.util.Date;

public class Transaction {
	private static long genericId = 0;
	private long id;
	private Date transactionDate;
	private long fromAccount;
	private long toAccount;
	private double amount;
	private int status;
	private String content;
	private String errorReason;
	
	public Transaction(Date transactionDate, long fromAccount, long toAccount, double amount, int status,
			String content, String errorReason) {
		super();
		this.id = ++genericId;
		this.transactionDate = transactionDate;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.status = status;
		this.content = content;
		this.errorReason = errorReason;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public long getToAccount() {
		return toAccount;
	}

	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getErrorReason() {
		return errorReason;
	}

	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transactionDate=" + transactionDate + ", fromAccount=" + fromAccount
				+ ", toAccount=" + toAccount + ", amount=" + amount + ", status=" + status + ", content=" + content
				+ ", errorReason=" + errorReason + "]/n";
	}
	
	

}
