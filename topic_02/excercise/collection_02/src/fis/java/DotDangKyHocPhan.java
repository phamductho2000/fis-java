package fis.java;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DotDangKyHocPhan {
	private String ma;
	private Calendar ngayBatDau;
	private Calendar ngayKetThuc;
	private List<PhieuDangKyHocPhan> dsPhieuDangKy = new ArrayList<PhieuDangKyHocPhan>();

	public DotDangKyHocPhan(String ma, Calendar ngayBatDau, Calendar ngayKetThuc) {
		this.ma = ma;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	// Cau 3: Lay ra danh sach sinh vien dang ky nhieu mon hoc nhat
	// Chu y : chi quan tam den nhung phieu dang ky hop le
	public List<SinhVien> getDsSinhVien(MonHoc monHoc) {
		dsPhieuDangKy.stream().filter(pDk -> pDk.laHopLe()).forEach(pDk -> pDk.getDsMonHoc().stream());
		return null;
	}

	// Cau 4:Lay ra danh sach cac mon hoc co the mo lop. Mon do co the mo lop
	// khi so luong dang ky hoc mon hoc do lon hon hoac bang soSinhVienToiThieu
	// Chu y : chi quan tam den nhung phieu dang ky hop le
	public List<MonHoc> getDsMonHoc(int soSinhVienToiThieu) {
		//lay tat ca cac mon hoc trong cac phieu dang ky hop le
		List<MonHoc> layTatCaMh = new ArrayList<MonHoc>();
		for (PhieuDangKyHocPhan pDk : dsPhieuDangKy) {
			if(pDk.laHopLe()) {
				layTatCaMh.addAll(pDk.getDsMonHoc());
			}
		}
		
		//dem moi mon hoc co bao nhieu luot dang ky
		Map<MonHoc, Integer> mapMh = new HashMap<MonHoc, Integer>();
		for(MonHoc mh : layTatCaMh) {
			if(mapMh.containsKey(mh)) {
				mapMh.put(mh, mapMh.get(mh) + 1);
			} else {
				mapMh.put(mh, 1);
			}
		}
		
		//lay ra danh sach nhung mon co so luong dang ky >= so sinh vien toi thieu
		List<MonHoc> result = new ArrayList<MonHoc>();
		for (Map.Entry<MonHoc, Integer> entry : mapMh.entrySet()) {
	        if(entry.getValue() >= soSinhVienToiThieu) {
	        	result.add(entry.getKey());
	        }
	    }
		return result;
		 
	}

	public void themPhieuDangKyHocPhan(PhieuDangKyHocPhan phieuDangKyHocPhan) {
		this.dsPhieuDangKy.add(phieuDangKyHocPhan);
	}
}
