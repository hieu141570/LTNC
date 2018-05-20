/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import OBJECT.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hieu
 */
public class LoginConnUtils {
    public static Connection getLoginConnection() throws SQLException, ClassNotFoundException{
        return MySQLConnUtils.getMySQLConnection();
    }
    public void add(String user, String password, int level){
        try{
            String sql = "insert into phongkham.tbl_login (user, password, level) values('" + user + "','" + password + "', '" + level + "')";
            Connection conn = getLoginConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error when add this account", 0);
        }
    }
    public void edit(int ID, String user, String password){
        try{
            String sql = "update phongkham.tbl_login set ID = '" + ID + "', user = '" + user + "', password = '" + password + "'";
            Connection conn = getLoginConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error when edit this account", 0);
        }
    }
    public void delete(int ID){
        try{
            String sql = "delete from phongkham.tbl_login where ID = '" + ID + "'";
            Connection conn = getLoginConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", 0);
        }
    }
    public ArrayList<Login> load(){
        ArrayList<Login> listLogin = new ArrayList<>();
        try{
            String sql = "select * from phongkham.tbl_login";
            Login l = new Login();
            Connection conn = getLoginConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                l = new Login();
                l.setId(rs.getInt("ID"));
                l.setUser(rs.getString("user"));
                l.setPasswd(rs.getString("password"));
                listLogin.add(l);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", 0);
        }
        return listLogin;
    }
    public boolean checkLogin(String user, String password){
        boolean chk = false;
        try{
            String sql = "select * from tbl_login where user = '" + user + "' and password ='" + password + "'";
            Connection conn = getLoginConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                chk = true;
            }
        }
        catch(Exception ex){
            Logger.getLogger(LoginConnUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public int getMaxID(){
        int maxID = 0;
        String sql = "select max(ID) from phongkham.tbl_login";
        try{
            Connection conn = getLoginConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                maxID = rs.getInt(1);
            }
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Lấy maxID lỗi", 0);
        }
        return maxID;
    }
    public Login getAccount(int ID){
        Login l = new Login();
        String sql = "select * from phongkham.tbl_login where ID = '" + ID + "';";
        try{
            Connection conn = getLoginConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                l.setUser(rs.getString("user"));
                l.setPasswd(rs.getString("password"));
                l.setId(rs.getInt("ID"));
            }
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error when get this account", 0);
        }
        return l;
    }
    public int phanQuyen(String user){
        int level = 0;
        String sql = "select level from phongkham.tbl_login where user = '" + user + "';";
        try{
            Connection conn = getLoginConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                level = rs.getInt(1);
            }
            conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error when get level of Account", 0);
        }
        return level;
    }
    
}
