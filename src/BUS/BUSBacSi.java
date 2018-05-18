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
        dal.add(bs.getLogin_ID(), bs.getThongTinID(), bs.getMakhoa(), bs.getTrinhDo());
    }
    public void edit(BacSi bs){
        dal.edit(bs.getMaBS(), bs.getLogin_ID(), bs.getThongTinID(), bs.getMakhoa(), bs.getTrinhDo());
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
    public String getMaKhoa(int maBS){
        return dal.getMaKhoa(maBS);
    }
    public BacSi getBacSi(int maBS){
        return dal.getBacSi(maBS);
    }
}
