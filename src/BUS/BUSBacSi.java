/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.BacSiConnUtils;
import OBJECT.BacSi;
import java.util.ArrayList;

/**
 *
 * @author Hieu
 */
public class BUSBacSi {
    BacSiConnUtils dal = new BacSiConnUtils();
    public void add(BacSi bs){
        dal.add(bs.getMaBS(), bs.getHoTenBS(),bs.getAge(), bs.getAddr(), bs.getPhoneNumber(), bs.getEmail(), bs.getMaKhoa(), bs.getGioiTinh(), bs.getTrinhDo());
    }
    public void edit(BacSi bs){
        dal.edit(bs.getMaBS(), bs.getHoTenBS(), bs.getAge(), bs.getAddr(), bs.getPhoneNumber(), bs.getEmail(), bs.getGioiTinh(), bs.getMaKhoa(), bs.getTrinhDo());
    }
    public void delete(BacSi bs){
        dal.delete(bs.getMaBS());
    }
    public void delete(int maBS){
        dal.delete(maBS);
    }
    public ArrayList<BacSi> getDataSource(){
        return dal.getDataSource();
    }
}
