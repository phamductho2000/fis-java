package fis.java;
import java.util.*;

public class PhieuDangKyHocPhan {
    private SinhVien sv;
    private List<MonHoc> dsMonHoc = new ArrayList<MonHoc>();

    private DotDangKyHocPhan dotDangKy;

    public PhieuDangKyHocPhan(SinhVien sv, DotDangKyHocPhan dotDangKy){
        this.sv = sv;
        this.dotDangKy = dotDangKy;
        this.dotDangKy.themPhieuDangKyHocPhan(this);
    }

    public boolean addMonHoc(MonHoc monHoc){
        return dsMonHoc.add(monHoc);
    }

    //Cau 2 : Mot phieu dang ky hoc phan duoc xem la hop le
    // khi cac mon hoc do sinh vien chon hoc deu hop le.
    public boolean laHopLe(){
    	int count = 0;
        //TODO
    	for(MonHoc mh : dsMonHoc) {
    		if(sv.coTheDangKyHoc(mh)) {
    			count++;
    		}
    	}
        return count == dsMonHoc.size();
    }

	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}
    
}
