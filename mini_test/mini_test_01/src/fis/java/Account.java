package fis.java;

import java.util.Objects;

public class Account implements Cloneable {
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

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance="
				+ balance + ", status=" + status + "]/n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountNumber, other.accountNumber) && id == other.id;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
    }
}
