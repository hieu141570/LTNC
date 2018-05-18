/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.BacSiConnUtils.getBacSiConnection;
import OBJECT.DuocSi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 *
 */
public class DuocSiConnUtils {
    public static Connection getDuocSiConnection() throws SQLException, ClassNotFoundException{
        return MySQLConnUtils.getMySQLConnection();
    }
    public static void addDuocSi(int maDuocSi, int thongTinID,int loginID){
        try{
            Connection conn = getDuocSiConnection();
            String sql = "insert into phongkham.tbl_bac_si (maDuocSi, , tbl_thongtin_id, tbl_login_ID) values ('"
                        +maDuocSi+ "', '"
                        +thongTinID+ "', '"
                        +loginID+ "');";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Add DS Error", 0);
        }
    }
     public static void editDuocSi(int maDuocSi, int thongTinID,int loginID){
        try{
            Connection conn = getDuocSiConnection();
            String sql = "update phongkham.tbl_bac_si set "
               
                        + "tbl_thongtin_id = '" +thongTinID+ "', "
                        + " tbl_login_ID = '" +loginID+ "', "
                        + "where maDuocSi = '" +maDuocSi+ "';";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Edit Doctor Error", 0);
        }
     }
      public static void delete(int maDuocSi){
        try{
            String sql = "delete from phongkham.tbl_bac_si where maBS = '" + maDuocSi + "'";
            Connection conn = getDuocSiConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Delete Doctor Error", 0);
        }
    }
     public ArrayList getDataSource(){
        ArrayList<DuocSi> listDuocSi = new ArrayList<DuocSi>();
        String sql = "select * from tbl_duoc_si";
        DuocSi ds = new DuocSi();
        try{
            Connection conn = getDuocSiConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ds = new DuocSi();
                ds.setMaDuocSi(rs.getInt("maDuocSi"));
                ds.setThongTinID(rs.getInt("tbl_thongtin_id"));
                ds.setLoginID(rs.getInt("tbl_login_ID"));
            
                listDuocSi.add(ds);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", 0);
        }
        return listDuocSi;
    }
    
}
