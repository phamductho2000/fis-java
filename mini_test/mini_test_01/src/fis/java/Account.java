package fis.java;

public class Account {
	private static long genericId = 0;
	private long id;
	private String accountNumber;
	private String accountName;
	private double balance;
	private int status;
	
	public Account(String accountNumber, String accountName, double balance, int status) {
		super();
		this.id = ++genericId;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = balance;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}

