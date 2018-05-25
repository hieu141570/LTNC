/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import OBJECT.ThongTin;
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
public class ThongTinConnUtils {
    public static Connection getThongTinConnection()throws SQLException, ClassNotFoundException{
        return MySQLConnUtils.getMySQLConnection();
    }
    
    public void add(String sdt, String hoTen, String diaChi, int namSinh, String gioiTinh, String email){
        String sql = "insert into phongkham.tbl_thongtin(hoten, diachi, sdt, namsinh, email, gioiTinh) values('"
                + hoTen + "', '"
                + diaChi + "', '"
                + sdt + "', '"
                + namSinh + "', '"
                + email + "', '"
                + gioiTinh + "');";
        try{
            Connection conn = getThongTinConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error when add information", 0);
        }
    }
    public void edit(int ID, String sdt, String hoTen, String diaChi, int namSinh, String eMail, String gioiTinh){
        String sql = "update phongkham.tbl_thongtin set "
                + "hoten = '" + hoTen + "', "
                + "diachi = '" + diaChi + "', "
                + "namsinh = '" + namSinh + "', "
                + "email = '" + eMail + "', "
                + "gioiTinh = '" + gioiTinh + "' "
                + "where id = '" + ID + "';";
        try{
            Connection conn = getThongTinConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error when edit information", 0);
        }
    }
    public void edit(String sdt, String hoTen, String diaChi, int namSinh, String eMail, String gioiTinh){
        String sql = "update phongkham.tbl_thongtin set "
                + "hoten = '" + hoTen + "', "
                + "diachi = '" + diaChi + "', "
                + "namsinh = '" + namSinh + "', "
                + "email = '" + eMail + "', "
                + "gioiTinh = '" + gioiTinh + "' "
                + "where id = '" + hoTen + "';";
        try{
            Connection conn = getThongTinConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error when edit information", 0);
        }
    }
    public void delete(int ID){
        String sql = "delete from phongkham.tbl_thongtin where id = '" + ID + "';";
        try{
            Connection conn = getThongTinConnection();
            Statement st = conn.createStatement();
            st.execute(sql);
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error when delete information", 0);
        }
    }
    public ThongTin getThongTin(int id){
        ThongTin infor = new ThongTin();
        String sql = "select * from phongkham.tbl_thongtin where id = '" + id + "';";
        try{
            Connection conn = getThongTinConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                infor.setId(rs.getInt("id"));
                infor.setDiaChi(rs.getString("diachi"));
                infor.setEmail(rs.getString("email"));
                infor.setHoTen(rs.getString("hoten"));
                infor.setGioiTinh(rs.getString("gioiTinh"));
                infor.setNamSinh(rs.getInt("namsinh"));
                infor.setSdt(rs.getString("sdt"));
            }
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", 0);
        }
        return infor;
    }
    public int getMaxID(){
        int maxID = 0;
        String sql = "select max(id) from phongkham.tbl_thongtin;";
        try{
            Connection conn = getThongTinConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                maxID = rs.getInt(1);
            }
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error when get max ID", 0);
        }
        return maxID;
    }
}
