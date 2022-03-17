package fis.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountManagement {
	public static List<Account> accounts = new ArrayList<Account>();

	public List<Account> getAccounts() {
		return accounts;
	}

	public boolean addAccount(Account account) {
		return accounts.add(account);
	}

	public boolean updateAccountById(long id, String accountName, int status) {
		Optional<Account> account = accounts.stream().filter(s -> s.getId() == id).findAny();
		if (account.isPresent()) {
			Account updateAccount = account.get();
			int index = accounts.indexOf(updateAccount);
			updateAccount.setAccountName(accountName);
			updateAccount.setStatus(status);
			accounts.set(index, updateAccount);
			return true;
		}
		return false;
	}

	public boolean removeAccountById(long id) {
		Optional<Account> account = accounts.stream().filter(s -> s.getId() == id).findAny();
		if (account.isPresent()) {
			Account removeAccount = account.get();
			accounts.remove(removeAccount);
			return true;
		}
		return false;
	}

	public double getBalanceByAccountNumber(String accountNumber) {
		Optional<Account> account = accounts.stream().filter(s -> s.getAccountNumber().equals(accountNumber)).findAny();
		if (account.isPresent()) {
			return account.get().getBalance();
		}
		return 0;
	}
	
	public boolean makeTransaction(String fromAccountNumber, String toAccountNumber, double amount) {
		Optional<Account> oFromAccount = accounts.stream().filter(s -> s.getAccountNumber().equals(fromAccountNumber)).findAny();
		Optional<Account> oToAccount = accounts.stream().filter(s -> s.getAccountNumber().equals(toAccountNumber)).findAny();
		if(oFromAccount.isPresent() && oToAccount.isPresent()) {
			Account fromAccount = oFromAccount.get();
			Account toAccount = oToAccount.get();
			fromAccount.setBalance(fromAccount.getBalance() - amount);
			toAccount.setBalance(toAccount.getBalance() + amount);
			accounts.set(accounts.indexOf(fromAccount), fromAccount);
			accounts.set(accounts.indexOf(toAccount), toAccount);
			return true;
		}
		return false;
	}

}
