package fis.java;

import java.util.*;

public class ChuongTrinhHoc {
    private String ten;
    private Calendar ngayDuocDuyet;
    private List<MonHoc> dsMonHoc = new ArrayList<MonHoc>();
    public static ChuongTrinhHoc SINGLETON = new ChuongTrinhHoc("Cong nghe thong tin", new GregorianCalendar(2000,0,1));

    private ChuongTrinhHoc(String ten, Calendar ngayDuocDuyet) {
        this.ten = ten;
        this.ngayDuocDuyet = ngayDuocDuyet;
    }

    public boolean addMonHoc(MonHoc monHoc){
        return this.dsMonHoc.add(monHoc);
    }

	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}
    
    
}
