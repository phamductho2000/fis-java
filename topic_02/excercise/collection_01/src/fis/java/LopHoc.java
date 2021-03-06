package fis.java;


import java.util.*;
import java.util.stream.Collectors;

public class LopHoc {
  private String ten;
  private String giaoVien;
  private List<SinhVien> dsLop = new ArrayList<SinhVien>();

  public LopHoc(String ten, String giaoVien){
    this.ten = ten;
    this.giaoVien = giaoVien;
  }

  public boolean them(SinhVien svMoi){
    return dsLop.add(svMoi);
  }

  //Cau 4
  public String inDiem(){
    /*
    Danh Sach Diem Lop : ten
    Giao Vien Chu Nhiem : giaoVien
    STT      MSSV        Ten              Diem TB   XepLoai
    1        123456      Nguyen Van A     8.4       GIOI
    2        678919      Nguyen Van B     6         TB-KHA
    3        112456      Nguyen Van C     7         KHA
    */
	StringBuilder sb = new StringBuilder();
	sb.append("Danh Sach Diem Lop : "+ten+"\n");
	sb.append("Giao Vien Chu Nhiem : "+giaoVien+"\n");
	sb.append("+-----------------+-----------------+-----------------+-----------------+-----------------+");
	sb.append("\n");
	sb.append(String.format("| %-15s ", "STT"));
	sb.append(String.format("| %-15s ", "MSSV"));
	sb.append(String.format("| %-15s ", "Ten"));
	sb.append(String.format("| %-15s ", "Diem TB"));
	sb.append(String.format("| %-15s |", "Xep Loai"));
	sb.append("\n");
	sb.append("+-----------------+-----------------+-----------------+-----------------+-----------------+");
	sb.append("\n");
	
	int index = 0;
	for (SinhVien s : dsLop) {
		sb.append(String.format("| %-15d ", ++index));
		sb.append(String.format("| %-15s ", s.getMssv()));
		sb.append(String.format("| %-15s ",  s.getTen()));
		sb.append(String.format("| %-15.2f ", s.tinhDiemTrungBinh()));
		sb.append(String.format("| %-15s |", s.xepLoai()));
		sb.append("\n");
	}
	sb.append("+-----------------+-----------------+-----------------+-----------------+-----------------+");
	sb.append("\n");
    //...
	return sb.toString();
  }

  //Cau 5
  public List<SinhVien> top10(){
    //Tra ve danh sach 10 sinh vien co diem trung binh lon nhat lop
	return dsLop.stream()
			.sorted((s2, s1) -> Double.compare(s1.tinhDiemTrungBinh(), s2.tinhDiemTrungBinh()))
			.limit(10)
			.collect(Collectors.toList());
    //...
  }

  //Cau 6
  public List<SinhVien> sinhVienYeu(){
    //Tra ve danh sach vien vien xep loai YEU
	return dsLop.stream()
				.filter(s -> s.xepLoai().equals("YEU"))
				.collect(Collectors.toList());
    //...
  }
}
