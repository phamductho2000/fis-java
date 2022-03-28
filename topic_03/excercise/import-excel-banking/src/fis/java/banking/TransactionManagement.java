package fis.java.banking;

import java.util.ArrayList;
import java.util.List;

public class TransactionManagement {
	public static List<TransactionHistory> transactionHistories = new ArrayList<TransactionHistory>();


	public static void setTransactionHistories(List<TransactionHistory> transactionHistories) {
		TransactionManagement.transactionHistories = transactionHistories;
	}

	public static boolean check(long accountNumber, String detail, double amount) {
		return transactionHistories.stream().anyMatch(
				t -> t.getAccountNumber() == accountNumber && t.getAmount() == amount && t.getDetail().equals(detail));
	}
}
