/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import OBJECT.bacSi;
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
public class bacSiConnUtils {
    public static Connection getBacSiConnUtils() throws SQLException, ClassNotFoundException{
        return MySQLConnUtils.getMySQLConnection();
    }
    public void add(int maBS, String hoTenBS, String addr, int phoneNumber, String email, String chuyenMon, String trinhDo){
        try{
            Connection conn = getBacSiConnUtils();
            String sql = "insert into phongkham.tbl_bac_si (maBS, hoTenBS, address, phonenumber, email, chuyenmon, trinhdo) values ('" 
                        + maBS + "','"
                        + hoTenBS + "','"
                        + addr + "','"
                        + phoneNumber + "','"
                        + email + "','"
                        + chuyenMon + "','"
                        + trinhDo + "')";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: \n" + ex.toString());
        }
    }
    public void edit(int maBS, String hoTenBS, String addr, int phoneNumber, String email, String chuyenMon, String trinhDo){
        try{
            Connection conn = getBacSiConnUtils();
            String sql = "update phongkham.tbl_bac_si set "
                        + "maBS = '" + maBS + "',"
                        + "address = '" + addr + "',"
                        + "phonenumber = '" + phoneNumber + "',"
                        + "email = '" + email + "',"
                        + "chuyenmon = '" + chuyenMon + "',"
                        + "trinhdo = '" + trinhDo + "'";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: \n" + ex.toString());
        }
    }
    public ArrayList load(){
        ArrayList<bacSi> listBS = new ArrayList<bacSi>();
        String sql = "select * from tbl_bac_si";
        bacSi bs = new bacSi();
        try{
            Connection conn = getBacSiConnUtils();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                bs = new bacSi();
                bs.setMaBS(rs.getInt("maBS"));
                //bs.setMaBS(Integer.parseInt(rs.getString("maBS")));
                bs.setHoTenBS(rs.getString("hoTenBS"));
                bs.setAddr(rs.getString("address"));
                bs.setPhoneNumber(rs.getInt("phonenumber"));
                //bs.setPhoneNumber(Integer.parseInt(rs.getString("phonenumber")));
                bs.setEmail(rs.getString("email"));
                bs.setChuyenMon(rs.getString("chuyenmon"));
                bs.setTrinhDo(rs.getString("trinhdo"));
                listBS.add(bs);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: \n"+ ex.toString());
        }
        return listBS;
    }
    public void delete(int maBS){
        try{
            String sql = "delete from phongkham.tbl_bac_si where maBS = '" + maBS + "'";
            Connection conn = getBacSiConnUtils();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: \n" + ex.toString());
        }
    }
}
