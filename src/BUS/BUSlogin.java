/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.loginConnUtils;
import OBJECT.login;

/**
 *
 * @author Hieu
 */
public class BUSlogin {
    loginConnUtils DAL = new loginConnUtils();
    public boolean checkLogin(login l){
        return DAL.checkLogin(l.getUser(), l.getPasswd());
    }
}
