package fis.java;

import java.util.ArrayList;
import java.util.List;

public class BangDiem {
    private List<Diem> dsDiem = new ArrayList<Diem>();

    public void themDiem(Diem diem){
        this.dsDiem.add(diem);
    }

	public List<Diem> getDsDiem() {
		return dsDiem;
	}

	public void setDsDiem(List<Diem> dsDiem) {
		this.dsDiem = dsDiem;
	}
    
}
