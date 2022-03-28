package fis.java.banking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		showMainMenu();
	}

	public static void showMainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Import dữ liệu excel");
		System.out.println("2.Kiểm tra giao dịch");
		System.out.println("Bạn chọn : ");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			importDataFromExcel();
			showMainMenu();
			break;
		case 2:
			if (ReadExcel.transactionHistories.isEmpty()) {
				System.out.println("Thông báo : bạn chưa import dữ liệu từ excel");
				showMainMenu();
			} else {
				showMenuCheckTransaction();
			}
			break;

		default:
			break;
		}
	}

	public static void showMenuCheckTransaction() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" 1.Kiểm tra giao dịch gửi tiền đi");
		System.out.println(" 2.Kiểm tra giao dịch nhận tiền vào");
		int ch = sc.nextInt();
		sc.nextLine();
		switch (ch) {
		case 1:
			System.out.println("Nhập stk người nhận tiền: ");
			String accountNumberRecipient= sc.nextLine();
			System.out.println("Nhập nội dung chuyển khoản : ");
			String detail = sc.nextLine();
			System.out.println("Nhập số tiền gửi đi : ");
			double amount =  Double.parseDouble(sc.nextLine());
			if(TransactionManagement.check(Long.parseLong(accountNumberRecipient), detail, -amount)) {
				System.out.println("Giao dịch này đã được thực hiện");
			} else {
				System.out.println("Giao dịch này chưa được thực hiện");
			}
			showMainMenu();
			break;
		case 2:
			System.out.println("Nhập stk người gửi tiền : ");
			String accountNumberSender = sc.nextLine();
			System.out.println("Nhập nội dung chuyển khoản : ");
			String detail1 = sc.nextLine();
			System.out.println("Nhập số tiền được nhận : ");
			double amount1 =  Double.parseDouble(sc.nextLine());
			if(TransactionManagement.check(Long.parseLong(accountNumberSender), detail1, amount1)) {
				System.out.println("Giao dịch này đã được thực hiện");
			} else {
				System.out.println("Giao dịch này chưa được thực hiện");
			}
			showMainMenu();
			break;

		default:
			break;
		}
	}

	public static void importDataFromExcel() {
		ReadExcel r = new ReadExcel();
		try {
			r.read("src/fis/java/banking/lich-su-giao-dich.xlsx");
			System.out.println("Import dữ liệu thành công");
		} catch (IOException e) {
			System.out.println("Import thất bại");
			e.printStackTrace();
		} 
	}

}
