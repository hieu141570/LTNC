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
    public void add(int loginID, int thongTinID, int maKhoa, String trinhDo){
        try{
            Connection conn = getBacSiConnection();
            String sql = "insert into phongkham.tbl_bac_si (tbl_login_ID, tbl_thongtin_id, trinhdo, tbl_khoa_id) values ('"
                        + loginID + "', '"
                        + thongTinID + "', '"
                        + trinhDo + "', '"
                        + maKhoa + "');";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Add Doctor Error", 0);
        }
    }
    public void edit(int maBS, int loginID, int thongTinID, int maKhoa, String trinhDo){
        try{
            Connection conn = getBacSiConnection();
            String sql = "update phongkham.tbl_bac_si set "
                    + "tbl_login_ID = '" + loginID + "', "
                    + "tbl_thongtin_id = '" + thongTinID + "', "
                        + "trinhdo = '" + trinhDo + "', "
                        + "tb_khoa_maKhoa = '" + maKhoa + "', "
                        + "where maBS = '" + maBS + "';";
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
                bs.setLogin_ID(rs.getInt("tbl_login_ID"));
                bs.setThongTinID(rs.getInt("tbl_thongtin_id"));
                bs.setTrinhDo(rs.getString("trinhdo"));
                bs.setMakhoa(rs.getInt("tbl_khoa_id"));
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
    public String getMaKhoa(int maBacSi){
        String maKhoa = "";
        String sql = "select tbl_khoa_maKhoa from phongkham.tbl_bac_si where maBS = '" + maBacSi + "';";
        try{
            Connection conn = getBacSiConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                maKhoa = rs.getString("tbl_khoa_maKhoa");
            }
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error when get maKhoa", 0);
        }
        return maKhoa;
    }
}
