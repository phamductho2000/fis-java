package fis.java;

import java.util.ArrayList;
import java.util.List;

public class TransactionManagement {
	public static List<Transaction> transactions = new ArrayList<Transaction>();
	
	public boolean addTransaction(Transaction t) {
		return transactions.add(t);
	}
}
