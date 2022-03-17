package fis.java;

public class Validation {

	public static boolean checkAccountNumberAccepted(String accountNumber) {
		boolean isExist = AccountManagement.accounts.stream()
				.anyMatch(s -> s.getAccountNumber().equals(accountNumber));
		if (accountNumber.length() == 12 && isExist == false)
			return true;

		return false;
	}
	
	public static boolean checkAccountNameAccepted(String accountName) {
		return accountName.length() > 5 && accountName.length() < 100;
	}
	
	public static boolean isAccountIdExist(long id) {
		return AccountManagement.accounts.stream()
				.anyMatch(s -> s.getId() == id);
	}
	
	public static boolean checkStatusAccountAccepted(int status) {
		return status == 0 || status == 1 || status == 2;
	}
	
	public static boolean checkStatus1FromAccountNumber(String accountNumber) {
		return AccountManagement.accounts.stream()
				.filter(s -> s.getAccountNumber().equals(accountNumber))
				.anyMatch(s -> s.getStatus() == 1);
	}
	
}
