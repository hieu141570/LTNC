/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.KhoaConnUtils;
import OBJECT.Khoa;

/**
 *
 * @author Hieu
 */
public class BUSKhoa {
    KhoaConnUtils dal = new KhoaConnUtils();
    public void add(Khoa khoa){
        dal.add(khoa.getTenKhoa(), khoa.getMaKhoa());
    }
    public void edit(Khoa khoa){
        dal.edit(khoa.getID(), khoa.getTenKhoa(), khoa.getMaKhoa());
    }
    public String getNameByID(int maKhoa){
        return dal.getNameByID(maKhoa);
    }
}
