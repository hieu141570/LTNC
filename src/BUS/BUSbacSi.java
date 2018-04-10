/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.bacSiConnUtils;
import OBJECT.bacSi;

/**
 *
 * @author Hieu
 */
public class BUSbacSi {
    bacSiConnUtils DAL = new bacSiConnUtils();
    public void add(bacSi bs){
        DAL.add(bs.getMaBS(), bs.getHoTenBS(), bs.getAddr(), bs.getPhoneNumber(), bs.getEmail(), bs.getChuyenMon(), bs.getTrinhDo());
    }
    public void edit(bacSi bs){
        DAL.edit(bs.getMaBS(), bs.getHoTenBS(), bs.getAddr(), bs.getPhoneNumber(), bs.getEmail(), bs.getChuyenMon(), bs.getTrinhDo());
    }
    public void delete(bacSi bs){
        DAL.delete(bs.getMaBS());
    }
    public void delete(int maBS){
        DAL.delete(maBS);
    }
}
