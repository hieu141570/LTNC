/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.MedicineConnUtils;
import OBJECT.Medicine;
import java.util.ArrayList;

/**
 *
 * @author Hieu
 */
public class BUSMedicine {
    MedicineConnUtils dal = new MedicineConnUtils();
    public void add(Medicine md){
        dal.add(md.getId(), md.getTenThuoc(),md.getMaThuoc(), md.getNhaSanXuat(),md.getPackType(),md.getUnitType(),md.getUnitPerPackage(), md.getNsx(),md.getHsd());
    }
    public void edit(Medicine md){
        dal.edit(md.getId(), md.getTenThuoc(),md.getMaThuoc(), md.getNhaSanXuat(),md.getPackType(),md.getUnitType(),md.getUnitPerPackage(), md.getNsx(),md.getHsd());
    }
    public void delete(Medicine md){
        dal.delete(md.getId());
    }
    public void delete(int Id){
        dal.delete(Id);
    }
    public ArrayList<Medicine> getDataSource(){
        return dal.getDataSource();
    }
    public Medicine getMedicine(int ID){
        return dal.getMedicine(ID);
    }
}
