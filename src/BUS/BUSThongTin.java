/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.ThongTinConnUtils;
import OBJECT.ThongTin;

/**
 *
 * @author Hieu
 */
public class BUSThongTin {
    private ThongTinConnUtils dal = new ThongTinConnUtils();
    public void add(ThongTin t){
        dal.add(t.getSdt(), t.getHoTen(), t.getDiaChi(), t.getNamSinh(), t.getGioiTinh(), t.getEmail());
    }
    public void edit(ThongTin t){
        dal.edit(t.getId(), t.getSdt(), t.getHoTen(), t.getDiaChi(), t.getNamSinh(), t.getEmail(), t.getGioiTinh());
    }
    public void delete(int ID){
        dal.delete(ID);
    }
    public ThongTin getThongTin(int thongTinID){
        return dal.getThongTin(thongTinID);
    }
    public int getMaxID(){
        return dal.getMaxID();
    }
}
