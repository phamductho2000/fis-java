package fis.java.banking;

import java.io.IOException;
import java.util.List;

public class Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadExcel r = new ReadExcel();
		List<TransactionHistory> transactionHistories = r.read("src/fis/java/banking/lich-su-giao-dich.xlsx");
		transactionHistories.stream().forEach(s -> System.out.println(s));
	}

}