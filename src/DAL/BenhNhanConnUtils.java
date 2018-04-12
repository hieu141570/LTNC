/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import OBJECT.BenhNhan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hieu
 */
public class BenhNhanConnUtils {
    public static Connection getBenhNhanConnection() throws SQLException, ClassNotFoundException{
        return MySQLConnUtils.getMySQLConnection();
    }
    public void add(int maBenhNhan, String hoTenBenhNhan, int age, String address, int phoneNumber, String ngheNghiep){
        try{
            String sql = "insert into phongkham.tbl_benh_nhan (maBenhNhan, hoTenBN, age, address, phonenumber, ngheNghiep) values('"
                    + maBenhNhan + "','"
                    + hoTenBenhNhan +"','"
                    + age + "','"
                    + address + "','"
                    + phoneNumber + "','"
                    + ngheNghiep + "')";
            Connection conn = getBenhNhanConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", 0);
        }
    }
    public void edit(int maBenhNhan, String hoTenBenhNhan, int age, String address, int phoneNumber, String ngheNghiep){
        try{
            String sql = "update phongkham.tbl_benh_nhan set"
                    + "hoTenBN = '" + hoTenBenhNhan + "',"
                    + "age = '" + age + ","
                    + "address = '" + address + "'"
                    + "phonenumber = '" + phoneNumber + "',"
                    + "ngheNghiep = '" + ngheNghiep + "'"
                    + "where maBN = '" + maBenhNhan + "'";
            Connection conn = getBenhNhanConnection();
            Statement st = conn.createStatement();
            st.executeQuery(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", 0);
        }
    }
    public void delete(int maBenhNhan){
        try{
            String sql = "delete phongkham.tbl_benh_nhan where maBenhNhan = '" + maBenhNhan + "'";
            Connection conn = getBenhNhanConnection();
            Statement st = conn.createStatement();
            st.executeQuery(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Error", 0);
        }
    }
    public ArrayList<BenhNhan> getDataSource(){
        ArrayList<BenhNhan> listBN = new ArrayList<>();
        BenhNhan bn = new BenhNhan();
        try{
            String sql = "select * from phongkham.tbl_benh_nhan";
            Connection conn = getBenhNhanConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                bn = new BenhNhan();
                bn.setMaBenhNhan(rs.getInt("maBenhNhan"));
                bn.setHoTen(rs.getString("hoTenBN"));
                bn.setAge(rs.getInt("age"));
                bn.setAddr(rs.getString("address"));
                bn.setPhoneNumber(rs.getInt("phonenumber"));
                bn.setNgheNghiep(rs.getString("ngheNghiep"));
                listBN.add(bn);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Error", 0);
        }
        return listBN;
    }
}
