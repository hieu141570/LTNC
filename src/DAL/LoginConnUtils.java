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
    public void add(int ID, String user, String password){
        try{
            String sql = "insert into phongkham.tbl_login (ID, user, password) values('" + ID + "','" + user + "','" + password + "')";
            Connection conn = getLoginConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", 0);
        }
    }
    public void edit(int ID, String user, String password){
        try{
            String sql = "update phongkham.tbl_login set ID = '" + ID + "', user = '" + user + "', password = '" + password + "'";
            Connection conn = getLoginConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", 0);
        }
    }
    public void delete(int ID){
        try{
            String sql = "delete from phongkham.tbl_login where ID = '" + ID + "'";
            Connection conn = getLoginConnection();
            Statement st = conn.createStatement();
            st.executeQuery(sql);
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
    
}
