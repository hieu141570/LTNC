/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;


import DAL.DuocSiConnUtils;

import OBJECT.DuocSi;
import java.util.ArrayList;

public class BUSDuocSi {
 DuocSiConnUtils dal = new DuocSiConnUtils();
    public void add(DuocSi ds){
        dal.addDuocSi(ds.getMaDuocSi(),ds.getThongTinID(), ds.getLoginID());
    } 
     public void edit(DuocSi ds){
        dal.editDuocSi(ds.getMaDuocSi(), ds.getThongTinID(), ds.getLoginID());
    }
    public void delete(DuocSi ds){
        dal.delete(ds.getMaDuocSi());
    }
     public ArrayList<DuocSi> getDataSource(){
        return dal.getDataSource();
    }
    
}
