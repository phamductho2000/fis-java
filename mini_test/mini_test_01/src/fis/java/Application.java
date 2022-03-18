package fis.java;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		DataTest dt = new DataTest();
		runThread();
		menu();
	}

	public static void menu() {
		System.out.println("===== HỆ THỐNG QUẢN LÝ TÀI KHOẢN =====");
		System.out.println(" 1.Danh Sach Tai Khoan");
		System.out.println(" 2.Them Moi Tai Khoan");
		System.out.println(" 3.Cap Nhat Thong Tin Tai Khoan");
		System.out.println(" 4 Xoa Tai Khoan");
		System.out.println(" 5.Chuyen Khoan");
		System.out.println(" 6.Exit");
		System.out.println("Chon : ");
		AccountManagement accountManagement = new AccountManagement();
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println(showListAccount());
			menu();
			break;
		case 2:
			addAccount(accountManagement);
			break;
		case 3:
			updateAccountById(accountManagement);
			break;
		case 4:
			removeAccountById(accountManagement);
			break;
		case 5:
			makeTransaction(accountManagement);
			break;
		case 6:
			System.exit(0);
			break;

		default:
			break;
		}
	}

	public static String showListAccount() {
		if (AccountManagement.accounts.isEmpty()) {
			return "Danh sach tai khoan trong";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("+-----------------+-----------------+-----------------+-----------------+-----------------+");
		sb.append("\n");
		sb.append(String.format("| %-15s ", "ID"));
		sb.append(String.format("| %-15s ", "Ten Tai Khoan"));
		sb.append(String.format("| %-15s ", "So Tai Khoan"));
		sb.append(String.format("| %-15s ", "So Du"));
		sb.append(String.format("| %-15s |", "Trang Thai"));
		sb.append("\n");
		sb.append("+-----------------+-----------------+-----------------+-----------------+-----------------+");
		sb.append("\n");

		for (Account a : AccountManagement.accounts) {
			sb.append(String.format("| %-15d ", a.getId()));
			sb.append(String.format("| %-15s ", a.getAccountName()));
			sb.append(String.format("| %-15s ", a.getAccountNumber()));
			sb.append(String.format("| %-15f ", a.getBalance()));
			if (a.getStatus() == 0) {
				sb.append(String.format("| %-15s |", "Het Hieu Luc"));
			} else if (a.getStatus() == 1) {
				sb.append(String.format("| %-15s |", "Hieu Luc"));
			} else if (a.getStatus() == 2) {
				sb.append(String.format("| %-15s |", "Tam Khoa"));
			}
			sb.append("\n");
		}
		sb.append("+-----------------+-----------------+-----------------+-----------------+-----------------+");
		sb.append("\n");
		return sb.toString();
	}

	public static void addAccount(AccountManagement accountManagement) {
		Scanner sc = new Scanner(System.in);

		String accountName = inputAccountName();
		String accountNumber = inputAccountNumber();

		Account newAccount = new Account(accountNumber, accountName, 100000, 1);
		if (accountManagement.addAccount(newAccount)) {
			System.out.println("Them tai khoan thanh cong");
			menu();
		} else {
			System.out.println("Them tai khoan that bai");
		}
	}

	public static void updateAccountById(AccountManagement accountManagement) {
		Scanner sc = new Scanner(System.in);
		long id = inputAccountId();
		String accountName = inputAccountName();
		int status = inputAccountStatus();

		if (accountManagement.updateAccountById(id, accountName, status)) {
			System.out.println("Cap nhat tai khoan thanh cong");
			menu();
		} else {
			System.out.println("Cap nhat tai khoan that bai");
		}

	}

	public static void removeAccountById(AccountManagement accountManagement) {
		Scanner sc = new Scanner(System.in);
		long id = inputAccountId();

		System.out.println("Ban co chac chan muon xoa tai khoan co id la " + id);
		System.out.println("Y/N ? ");
		String ch = sc.nextLine();
		if (ch.toUpperCase().equals("Y")) {
			if (accountManagement.removeAccountById(id)) {
				System.out.println("Xoa tai khoan thanh cong");
				menu();
			} else {
				System.out.println("Xoa tai khoan that bai");
			}
		} else {
			menu();
		}
	}

	public static void makeTransaction(AccountManagement accountManagement) {
		Scanner sc = new Scanner(System.in);
		TransactionManagement transactionManagement = new TransactionManagement();

		System.out.println("Tu STK : ");
		String fromAccountNumber = sc.nextLine();
		System.out.println("Den STK : ");
		String toAccountNumber = sc.nextLine();
		System.out.println("So tien chuyen khoan : ");
		double amount = Double.parseDouble(sc.nextLine());
		System.out.println("Noi dung chuyen khoan : ");
		String content = sc.nextLine();
		System.out.println("Ban co chac chan muon thuc hien giao dich ?");
		System.out.println("Y/N ? ");
		String ch = sc.nextLine();

		// Chon Y thi thuc hien giao dich
		if (ch.toUpperCase().equals("Y")) {
			if (!Validation.checkStatus1FromAccountNumber(fromAccountNumber)) {
				String err = "Loi : Tai khoan nguon phai co trang thai hieu luc";
				System.out.println(err);
				transactionManagement.addTransaction(new Transaction(new Date(), Long.valueOf(fromAccountNumber),
						Long.valueOf(toAccountNumber), amount, 0, content, err));
			} else if (!Validation.checkStatus1FromAccountNumber(toAccountNumber)) {
				String err = "Loi : Tai khoan dich phai co trang thai hieu luc";
				System.out.println(err);
				transactionManagement.addTransaction(new Transaction(new Date(), Long.valueOf(fromAccountNumber),
						Long.valueOf(toAccountNumber), amount, 0, content, err));
			} else if (accountManagement.getBalanceByAccountNumber(fromAccountNumber) <= amount) {
				String err = "So du tai khoan nguoi gui phai co so du lon hon hoac bang so tien giao dich";
				System.out.println(err);
				transactionManagement.addTransaction(new Transaction(new Date(), Long.valueOf(fromAccountNumber),
						Long.valueOf(toAccountNumber), amount, 0, content, err));
			} else {
				if (accountManagement.makeTransaction(fromAccountNumber, toAccountNumber, amount)) {
					System.out.println("Giao dich thanh cong");
					transactionManagement.addTransaction(new Transaction(new Date(), Long.valueOf(fromAccountNumber),
							Long.valueOf(toAccountNumber), amount, 1, content, ""));
					menu();
				}
			}
		} else {
			menu();
		}
	}

	public static String inputAccountNumber() {
		Scanner sc = new Scanner(System.in);
		String accountNumber = "";
		while (true) {
			System.out.println("Nhap so tai khoan : ");
			accountNumber = sc.nextLine();
			if (!Validation.checkAccountNumberAccepted(accountNumber)) {
				System.out.println("Loi : So tai khoan phai bang 12 ky tu va phai la duy nhat");
			} else {
				return accountNumber;
			}
		}
	}

	public static String inputAccountName() {
		Scanner sc = new Scanner(System.in);
		String accountName;
		while (true) {
			System.out.println("Nhap ten tai khoan : ");
			accountName = sc.nextLine();
			if (!Validation.checkAccountNameAccepted(accountName)) {
				System.out.println("Loi : Ten tai khoan phai lon hon 5 ky tu va nho hon 100 ky tu");
			} else {
				return accountName;
			}
		}
	}

	public static int inputAccountStatus() {
		Scanner sc = new Scanner(System.in);
		int status;
		while (true) {
			System.out.println("Nhap trang thai : ");
			status = Integer.parseInt(sc.nextLine());
			if (!Validation.checkStatusAccountAccepted(status)) {
				System.out.println("Loi : Trang thai phai la 1 trong cac so : 0, 1, 2");

			} else {
				return status;
			}
		}
	}

	public static long inputAccountId() {
		Scanner sc = new Scanner(System.in);
		long id;
		while (true) {
			System.out.println("Nhap id tai khoan : ");
			id = Long.parseLong(sc.nextLine());
			if (!Validation.isAccountIdExist(id)) {
				System.out.println("Loi : Tai khoan khong hop le");
			} else {
				return id;
			}
		}
	}

	public static void runThread() {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Runnable worker = new NotificationThread();
		executor.execute(worker);
	}
}
