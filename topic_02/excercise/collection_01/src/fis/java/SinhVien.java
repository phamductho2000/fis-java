package fis.java;

import java.util.*;

public class SinhVien {
	private String mssv;
	private String ten;

	private Set<Diem> monDaHoc = new HashSet<Diem>();

	public SinhVien(String mssv, String ten) {
		this.mssv = mssv;
		this.ten = ten;
	}

	public Set<Diem> getMonDaHoc() {
		return monDaHoc;
	}

	public void setMonDaHoc(Set<Diem> monDaHoc) {
		this.monDaHoc = monDaHoc;
	}

	public boolean themDiem(Diem diemMoi) {
		return this.monDaHoc.add(diemMoi);
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	// Cau 1
	public double tinhDiemTrungBinh() {
		// Giong nhu cach tinh hien tai cua truong
		int total = monDaHoc.stream()
							.mapToInt(s -> s.getDiem())
							.sum();
		// ...
		return total / (double)monDaHoc.size();
	}

	// Cau 2
	public String bangDiem() {
		/*
		 * MSSV : 0203044 Ten : Nguyen Van A Danh Sach Diem STT Ten Mon Diem So Tin Chi
		 * 1 Cau Truc Du Lieu 1 8 3 2 Cau Truc Du Lieu 2 8 3 Diem Trung Binh 8.0
		 */
	
		StringBuilder sb = new StringBuilder();
		sb.append("MSSV : "+mssv+"\n");
		sb.append("Ten : "+ten+"\n");
		sb.append("Danh Sach Diem\n");
		sb.append("+-------+-----------------+-----------------+-----------------+");
		sb.append("\n");
		sb.append(String.format("| %-5s ", "STT"));
		sb.append(String.format("| %-15s ", "Ten Mon"));
		sb.append(String.format("| %-15s ", "Diem"));
		sb.append(String.format("| %-15s |", "So Tin Chi"));
		sb.append("\n");
		sb.append("+-------+-----------------+-----------------+-----------------+");
		sb.append("\n");
		
		int index = 0;
		for (Diem d : monDaHoc) {
			sb.append(String.format("| %-5d ", ++index));
			sb.append(String.format("| %-15s ", d.getMon().getTen()));
			sb.append(String.format("| %-15d ",  d.getDiem()));
			sb.append(String.format("| %-15d |", d.getMon().getTcLT() + d.getMon().getTcTH()));
			sb.append("\n");
		}
		sb.append("+-------+-----------------+-----------------+-----------------+");
		sb.append("\n");
		sb.append(String.format("Diem trung binh : %.2f", tinhDiemTrungBinh()));
		return sb.toString();
	}

	// Cau 3
	public String xepLoai() {
		/*
		 * Quy tac xep loai nhu sau DiemTB < 5 -> YEU DiemTB >= 5 va DiemTB < 6 -> TB
		 * DiemTB >= 6 va DiemTB < 7 -> TB-KHA DiemTB >= 7 va DiemTB < 8 -> KHA DiemTB
		 * >= 8 -> GIOI
		 */
		double tb = tinhDiemTrungBinh();
		if(tb < 5) return "YEU";
		if(tb >= 5 && tb < 6) return "TB";
		if(tb >= 6 && tb < 7) return "TB-KHA";
		if(tb < 5) return "YEU";
		if(tb >= 7 && tb < 8) return "KHA";
		return "GIOI";
		// ...
	}
}
