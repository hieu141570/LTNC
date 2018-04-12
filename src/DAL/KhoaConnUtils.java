/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import OBJECT.Khoa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Hieu
 */
public class KhoaConnUtils {
    public static Connection getKhoaConnection() throws SQLException, ClassNotFoundException{
        return MySQLConnUtils.getMySQLConnection();
    }
    public void add(int maKhoa, String tenKhoa, String chucNang){
        try{
            String sql = "insert into phongkham.tbl_khoa (maKhoa, tenKhoa, chucNang) values('"
                    + maKhoa + "','"
                    + tenKhoa + "','"
                    + chucNang + "','";
            Connection conn = getKhoaConnection();
            Statement st = conn.createStatement();
            st.executeQuery(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Add Error", 0, null);
        }
    }
    public void edit(int maKhoa, String tenKhoa, String chucNang){
        try{
            String sql = "update phongkham.tbl_khoa set"
                    + "tenKhoa = '" + tenKhoa + "',"
                    + "chucNang = '" + chucNang + "'"
                    + "where maKhoa = '" + maKhoa + "'";
            Connection conn = getKhoaConnection();
            Statement st = conn.createStatement();
            st.executeQuery(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Edit Error", 0);
        }
    }
    public void delete(int maKhoa){
        try{
            String sql = "delete phongkham.tbl_khoa where maKhoa = '" + maKhoa + "'";
            Connection conn = getKhoaConnection();
            Statement st = conn.createStatement();
            st.executeQuery(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Delete Error", 0);
        }
    }
    public String getNameByID(int maKhoa){
        String tenKhoa = "";
        String sql = "select tenKhoa from phongkham.tbl_khoa where maKhoa = '"+ maKhoa + "'";
        try{
            Connection conn = getKhoaConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                tenKhoa = rs.getString("tenKhoa");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error to get Name", 0);
        }
        return tenKhoa;
    }
}
