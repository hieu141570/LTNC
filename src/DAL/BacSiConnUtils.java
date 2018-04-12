/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import OBJECT.BacSi;
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
public class BacSiConnUtils {
    public static Connection getBacSiConnection() throws SQLException, ClassNotFoundException{
        return MySQLConnUtils.getMySQLConnection();
    }
    public void add(int maBS, String hoTenBS, int age, String addr, int phoneNumber, String email, int maKhoa, String gioiTinh, String trinhDo){
        try{
            Connection conn = getBacSiConnection();
            String sql = "insert into phongkham.tbl_bac_si (maBS, hoTenBS, age, address, phonenumber, email, gioiTinh, trinhdo, maKhoa) values ('" 
                        + maBS + "','"
                        + hoTenBS + "','"
                        + age + "','"
                        + addr + "','"
                        + phoneNumber + "','"
                        + email + "','"
                        + gioiTinh + "','"
                        + trinhDo + "','"
                        + maKhoa + "')";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Add Doctor Error", 0);
        }
    }
    public void edit(int maBS, String hoTenBS, int age, String addr, int phoneNumber, String email, String gioiTinh, int maKhoa, String trinhDo){
        try{
            Connection conn = getBacSiConnection();
            String sql = "update phongkham.tbl_bac_si set "
                        + "hoTenBS = '" + hoTenBS + "',"
                        + "address = '" + addr + "',"
                        + "phonenumber = '" + phoneNumber + "',"
                        + "email = '" + email + "',"
                        + "gioiTinh = '" + gioiTinh + "',"
                        + "trinhdo = '" + trinhDo + "'"
                        + "maKhoa = '" + maKhoa + "',"
                        + "where maBS = '" + maBS + "'";
            Statement st = conn.createStatement();
            st.execute(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Edit Doctor Error", 0);
        }
    }
    public ArrayList getDataSource(){
        ArrayList<BacSi> listBS = new ArrayList<BacSi>();
        String sql = "select * from tbl_bac_si";
        BacSi bs = new BacSi();
        try{
            Connection conn = getBacSiConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                bs = new BacSi();
                bs.setMaBS(rs.getInt("maBS"));
                //bs.setMaBS(Integer.parseInt(rs.getString("maBS")));
                bs.setHoTenBS(rs.getString("hoTenBS"));
                bs.setAge(rs.getInt("age"));
                bs.setAddr(rs.getString("address"));
                bs.setPhoneNumber(rs.getInt("phonenumber"));
                //bs.setPhoneNumber(Integer.parseInt(rs.getString("phonenumber")));
                bs.setEmail(rs.getString("email"));
                bs.setGioiTinh(rs.getString("gioiTinh"));
                bs.setTrinhDo(rs.getString("trinhdo"));
                listBS.add(bs);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", 0);
        }
        return listBS;
    }
    public void delete(int maBS){
        try{
            String sql = "delete from phongkham.tbl_bac_si where maBS = '" + maBS + "'";
            Connection conn = getBacSiConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Delete Doctor Error", 0);
        }
    }
}
