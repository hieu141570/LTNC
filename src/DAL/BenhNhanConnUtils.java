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
    public void add(String ngheNghiep, int loginID, int thongTinID){
        try{
            String sql = "insert into phongkham.tbl_benh_nhan (ngheNghiep, tbl_login_ID, tbl_thongtin_id) values('"
                    + ngheNghiep +"','"
                    + loginID + "','"
                    + thongTinID + "';";
            Connection conn = getBenhNhanConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Lỗi thêm bệnh nhân", 0);
        }
    }
    public void edit(int maBenhNhan, String ngheNghiep, int thongTinID, int loginID){
        try{
            String sql = "update phongkham.tbl_benh_nhan set "
                    + "ngheNghiep = '" + ngheNghiep + "', "
                    + "tbl_thongtin_id = '" + thongTinID + "', "
                    + "tbl_login_id = '" + loginID + "' "
                    + "where maBenhNhan = '" + maBenhNhan + "';";
            Connection conn = getBenhNhanConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Lỗi sửa bệnh nhân", 0);
        }
    }
    public int getThongTinID(int maBenhNhan){
        int thongTinID = 0;
        String sql = "select tb_thongtin_id from phongkham.tbl_benhnhan where maBenhNhan = '" + maBenhNhan + "';";
        try{
            Connection conn = getBenhNhanConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                thongTinID = rs.getInt("tbl_thongtin_id");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Lỗi lấy id thông tin bệnh nhân", 0);
        }
        return thongTinID;
    }
    public int getLoginID(int maBenhNhan){
        int loginID = 0;
        String sql = "select tb_thongtin_id from phongkham.tbl_benhnhan where maBenhnhan = '" + maBenhNhan + "';";
        try{
            Connection conn = getBenhNhanConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                loginID = rs.getInt("tbl_thongtin_id");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Lỗi lấy id login bệnh nhân", 0);
        }
        return loginID;
    }
    public void delete(int maBenhNhan){
        try{
            String sql = "delete phongkham.tbl_benh_nhan where maBenhNhan = '" + maBenhNhan + "'";
            Connection conn = getBenhNhanConnection();
            Statement st = conn.createStatement();
            st.executeQuery(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Lỗi xóa bệnh nhân", 0);
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
                bn.setLoginID(rs.getInt("tbl_login_ID"));
                bn.setThongTinID(rs.getInt("tbl_thongtin_id"));
                bn.setNgheNghiep(rs.getString("ngheNghiep"));
                listBN.add(bn);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Lỗi lấy danh sách bệnh nhân", 0);
        }
        return listBN;
    }
    public BenhNhan getBenhNhan(int maBenhNhan){
        BenhNhan bn = new BenhNhan();
        try{
            String sql = "select * from phongkham.tbl_benh_nhan "
                    + "where maBenhNhan = " + maBenhNhan;
            Connection conn = getBenhNhanConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                bn.setMaBenhNhan(rs.getInt("maBenhNhan"));
                bn.setLoginID(rs.getInt("tbl_login_ID"));
                bn.setThongTinID(rs.getInt("tbl_thongtin_id"));
                bn.setNgheNghiep(rs.getString("ngheNghiep"));
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Lỗi lấy thông tin bệnh nhân", 0);
        }
        return bn;
    }
}
