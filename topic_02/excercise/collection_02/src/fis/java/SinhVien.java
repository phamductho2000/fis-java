package fis.java;

import java.util.List;

public class SinhVien {
	private String masv;
	private String ten;
	private BangDiem bangDiem;

	public SinhVien(String masv, String ten, BangDiem bangDiem) {
		this.ten = ten;
		this.masv = masv;
		this.bangDiem = bangDiem;
	}

	// Xem ky dinh nghia giong nhau
	public boolean equals(Object that) {
		if (that == null)
			return false;
		if (!(that instanceof SinhVien))
			return false;
		SinhVien thatSinhVien = (SinhVien) that;
		return this.ten.equals(thatSinhVien.ten) && this.masv.equals(thatSinhVien.masv);
	}

	//
	// Cau 1 : Sinh vien chi co the dang ky hoc 1 mon hoc khi
	// - Mon hoc do nam trong chuong trinh.
	// - Sinh vien phai chua dau mon hoc do
	// - Phai dau tat ca cac mon tien quyet cua mon hoc do.
	// Chu y:
	// Mon hoc co nhieu diem diem cua mon do la diem cuoi cung
	// Doc yeu cau that ky nha neu ko thoa thi ko co diem dau do
	public boolean coTheDangKyHoc(MonHoc monHoc) {
		// TODO
		if(monHoc == null) return false;
		if(ktraMhocThuocCtrinhKhong(monHoc)) {
			if(!ktraSvDaDauMhocChua(monHoc)) {
				if(ktraSvDaDauCacMhocTienQuyetCuaMhocDoChua(monHoc)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean ktraMhocThuocCtrinhKhong(MonHoc monHoc) {
    	return ChuongTrinhHoc.SINGLETON.getDsMonHoc().stream()
    			.anyMatch(s -> s.equals(monHoc));
	}

	public boolean ktraSvDaDauMhocChua(MonHoc monHoc) {
		return bangDiem.getDsDiem().stream()
				.anyMatch(s -> s.getMonHoc().equals(monHoc) && s.getDiemCuoiCung() > 4);
	}
	
	public boolean ktraSvDaDauCacMhocTienQuyetCuaMhocDoChua(MonHoc monHoc) {
		int count = 0;
		List<Diem> dsDiem = bangDiem.getDsDiem();
		List<MonHoc> dsMonTienQuyet = monHoc.getDsMonTienQuyet();
		for (Diem d : dsDiem) {
			for (MonHoc mTQ : dsMonTienQuyet) {
				if(d.getMonHoc().equals(mTQ) && d.getDiemCuoiCung() > 4) count++;;
			}
		}
		return count == dsMonTienQuyet.size();
	}

	public BangDiem getBangDiem() {
		return bangDiem;
	}
}
