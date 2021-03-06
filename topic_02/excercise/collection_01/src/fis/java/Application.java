package fis.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonHoc java = new MonHoc("java", 2, 3);
		MonHoc c = new MonHoc("c", 2, 3);
		MonHoc php = new MonHoc("php", 2, 3);
		
		Set<Diem> diem1s = new HashSet<Diem>();
		diem1s.add(new Diem(java, 3));
		diem1s.add(new Diem(c, 4));
		diem1s.add(new Diem(php, 7));
		
		Set<Diem> diem2s = new HashSet<Diem>();
		diem2s.add(new Diem(java, 5));
		diem2s.add(new Diem(c, 7));
		diem2s.add(new Diem(php, 7));
		
		Set<Diem> diem3s = new HashSet<Diem>();
		diem3s.add(new Diem(java, 9));
		diem3s.add(new Diem(c, 9));
		diem3s.add(new Diem(php, 7));
		
		Set<Diem> diem4s = new HashSet<Diem>();
		diem4s.add(new Diem(java, 1));
		diem4s.add(new Diem(c, 2));
		diem4s.add(new Diem(php, 5));
		
		SinhVien sv1 = new SinhVien("001", "ThoPD");
		sv1.setMonDaHoc(diem1s);
		SinhVien sv2 = new SinhVien("002", "NamPD");
		sv2.setMonDaHoc(diem2s);
		SinhVien sv3 = new SinhVien("003", "AnPD");
		sv3.setMonDaHoc(diem3s);
		SinhVien sv4 = new SinhVien("004", "HungPD");
		sv4.setMonDaHoc(diem4s);
		
		LopHoc lh = new LopHoc("Lap trinh", "Nguyen Thanh Phuoc");
		lh.them(sv1);
		lh.them(sv2);
		lh.them(sv3);
		lh.them(sv4);
		
//		System.out.println(lh.inDiem());
//		System.out.println(sv2.tinhDiemTrungBinh());
		System.out.println(sv2.bangDiem());
//		System.out.println(sv.xepLoai());
//		lh.top10().stream()
//					.forEach(s -> System.out.println(s.getTen()));
//		lh.sinhVienYeu().stream()
//						.forEach(s -> System.out.println(s.getTen()));
	}

}
