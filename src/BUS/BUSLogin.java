/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.LoginConnUtils;
import OBJECT.Login;

/**
 *
 * @author Hieu
 */
public class BUSLogin {
    LoginConnUtils dal = new LoginConnUtils();
    public boolean checkLogin(Login l){
        return dal.checkLogin(l.getUser(), l.getPasswd());
    }
    public void add(Login l){
        dal.add(l.getUser(), l.getPasswd(), l.getLevel());
    }
    public int getMaxID(){
        return dal.getMaxID();
    }
    public Login getAccount(int ID){
        return dal.getAccount(ID);
    }
    public void delete(int ID){
        dal.delete(ID);
    }
}
