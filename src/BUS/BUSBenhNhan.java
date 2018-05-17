/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.BenhNhanConnUtils;
import OBJECT.BenhNhan;
import java.util.ArrayList;

/**
 *
 * @author Hieu
 */
public class BUSBenhNhan {
    private BenhNhanConnUtils dal = new BenhNhanConnUtils();
    public void add(BenhNhan bn){
        dal.add(bn.getNgheNghiep(), bn.getLoginID(), bn.getThongTinID());
    }
    public void edit(BenhNhan bn){
        dal.edit(bn.getMaBenhNhan(), bn.getNgheNghiep(), bn.getThongTinID(), bn.getLoginID());
    }
    public void delete(int maBenhNhan){
        dal.delete(maBenhNhan);
    }
    public ArrayList<BenhNhan> getDataSource(){
        return dal.getDataSource();
    }
    public BenhNhan getBenhNhan(int maBenhNhan){
        return dal.getBenhNhan(maBenhNhan);
    }
}
