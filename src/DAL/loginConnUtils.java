/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import OBJECT.login;
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
public class loginConnUtils {
    public static Connection getUserConnUtils() throws SQLException, ClassNotFoundException{
        return MySQLConnUtils.getMySQLConnection();
    }
    public void add(int ID, String user, String password){
        try{
            String sql = "insert into phongkham.tb_login (ID, user, password) values('" + ID + "','" + user + "','" + password + "')";
            Connection conn = getUserConnUtils();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: \n" + ex.toString());
        }
    }
    public void edit(int ID, String user, String password){
        try{
            String sql = "update phongkham.tbl_login set ID = '" + ID + "', user = '" + user + "', password = '" + password + "'";
            Connection conn = getUserConnUtils();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: \n" + ex.toString());
        }
    }
    public void delete(int ID){
        try{
            String sql = "delete from phongkham.tbl_login where ID = '" + ID + "'";
            Connection conn = getUserConnUtils();
            Statement st = conn.createStatement();
            st.executeQuery(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: \n" + ex.toString());
        }
    }
    public ArrayList<login> load(){
        ArrayList<login> listLogin = new ArrayList<>();
        try{
            String sql = "select * from phongkham.tbl_login";
            login l = new login();
            Connection conn = getUserConnUtils();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                l = new login();
                l.setId(rs.getInt("ID"));
                l.setUser(rs.getString("user"));
                l.setPasswd(rs.getString("password"));
                listLogin.add(l);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: \n" + ex);
        }
        return listLogin;
    }
    public boolean checkLogin(String user, String password){
        boolean chk = false;
        try{
            String sql = "select * from tbl_login where user = '" + user + "' and password ='" + password + "'";
            Connection conn = getUserConnUtils();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                chk = true;
            }
        }
        catch(Exception ex){
            Logger.getLogger(loginConnUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    
}
