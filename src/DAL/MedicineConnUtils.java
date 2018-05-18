/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import OBJECT.Medicine;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hieu
 */
public class MedicineConnUtils {

    public static Connection getMedicineConnection() throws SQLException, ClassNotFoundException {
        return MySQLConnUtils.getMySQLConnection();
    }

    public void add(int Id, String TenThuoc, String MaThuoc, String NhaSanXuat, String PackType, String UnitType, int UnitPerPackage, LocalDate Nsx, LocalDate Hsd) {
        try {
            Connection conn = getMedicineConnection();
            String sql = "insert into quanliphongkham.tbl_medicine (ID, tenThuoc, maThuoc,nhaSanXuat,packType,unitType,unitPerPackage,NSX,HSd) values ('"
                    + Id + "', '"
                    + TenThuoc + "', '"
                    + MaThuoc + "', '"
                    + NhaSanXuat + "','"
                    + PackType + "','"
                    + UnitType + "','"
                    + UnitPerPackage + "','"
                    + Nsx + "','"
                    + Hsd + "');";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Add Medicine Error", 0);
        }
    }

    public void edit(int Id, String TenThuoc, String MaThuoc, String NhaSanXuat, String PackType, String UnitType, int UnitPerPackage, LocalDate Nsx, LocalDate Hsd) {
        try {
            Connection conn = getMedicineConnection();
            String sql = "update into quanliphongkham.tbl_medicine set"
                    + "Id = '" + Id + "', '"
                    + "TenThuoc= '" + TenThuoc + "', '"
                    + "MaThuoc= '" + MaThuoc + "', '"
                    + "NhaSanXuat= '" + NhaSanXuat + "','"
                    + "PackType= '" + PackType + "','"
                    + "UnitType= '" + UnitType + "','"
                    + "UnitPerPackage= '" + UnitPerPackage + "','"
                    + "Nsx= '" + Nsx + "','"
                    + "Hsd= '" + Hsd + "');";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Edit Medicine Error", 0);
        }
    }

    public void delete(int maThuoc) {
        try {
            String sql = "delete from quanliphongkham.tbl_medicine where maThuoc = '" + maThuoc + "'";
            Connection conn = getMedicineConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Delete Medicine Error", 0);
        }
    }

    public ArrayList getDataSource() {
        ArrayList<Medicine> listMD = new ArrayList<Medicine>();
        String sql = "select * from tbl_medicine";
        Medicine md = new Medicine();
        try {
            Connection conn = getMedicineConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                md = new Medicine();
                md.setId(rs.getInt("Id"));
                md.setTenThuoc(rs.getString("TenThuoc"));
                md.setMaThuoc(rs.getString("MaThuoc"));
                md.setNhaSanXuat(rs.getString("NhaSanXuat"));
                md.setPackType(rs.getString("PackType"));
                md.setUnitType(rs.getString("UnitType"));
                md.setUnitPerPackage(rs.getInt("UnitPerPackage"));

                listMD.add(md);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", 0);
        }
        return listMD;
    }
    public Medicine getMedicine(int ID){
        Medicine md = new Medicine();
        String sql = "select * from phongkham.tbl_medicine where ID = '" + ID + "';";
        try{
            Connection conn = getMedicineConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                md.setId(rs.getInt("Id"));
                md.setTenThuoc(rs.getString("TenThuoc"));
                md.setMaThuoc(rs.getString("MaThuoc"));
                md.setNhaSanXuat(rs.getString("NhaSanXuat"));
                md.setPackType(rs.getString("PackType"));
                md.setUnitType(rs.getString("UnitType"));
                md.setUnitPerPackage(rs.getInt("UnitPerPackage"));
            }
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error when get medicine", 0);
        }
        return md;
    }
}
