package fis.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NotificationThread extends Thread {

	public void run() {

		while (true) {

			try {
				List<Account> oldListAccounts = cloneAccountList();

				Thread.sleep(1000);

				List<Account> newListAccounts = cloneAccountList();

				for (int i = 0; i < oldListAccounts.size(); i++) {
					Account newA = newListAccounts.get(i);
					Account oldA = oldListAccounts.get(i);
					if (newA.equals(oldA)) {
						double range = newListAccounts.get(i).getBalance() - oldListAccounts.get(i).getBalance();
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
						LocalDateTime now = LocalDateTime.now();
						if (range > 0) {
							System.out.println("Thong bao : TK " + newA.getAccountName() + " " + newA.getAccountNumber()
									+ " tang " + range + " vao luc " + dtf.format(now));
						} else if (range < 0) {
							System.out.println("Thong bao : TK " + newA.getAccountName() + " " + newA.getAccountNumber()
									+ " giam " + range + " vao luc " + dtf.format(now));
						}
					}

				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public List<Account> cloneAccountList() {
		List<Account> copyListAccount = new ArrayList<Account>();
		AccountManagement.accounts.stream().forEach(s -> {
			try {
				copyListAccount.add((Account) s.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		});

		return copyListAccount;
	}
}
