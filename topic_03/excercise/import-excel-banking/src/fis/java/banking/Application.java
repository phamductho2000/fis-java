package fis.java.banking;

import java.io.IOException;
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
		System.out.println(" 1.Kiểm tra giao dịch gửi tiền đi");
		System.out.println(" 2.Kiểm tra giao dịch nhận tiền vào");
	}

	public static void importDataFromExcel() {
		ReadExcel r = new ReadExcel();
		try {
			r.read("src/fis/java/banking/lich-su-giao-dich.xlsx");
			System.out.println("Import dữ liệu thành công");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Import thất bại");
			e.printStackTrace();

		}
	}

}
