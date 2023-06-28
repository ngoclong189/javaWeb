/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Admin
 */
public class Account {
    private int accID;
    private String username;
    private String password;
    private int seller;
    private int admin;

    public Account() {
    }

    public Account(int accID, String username, String password, int seller, int admin) {
        this.accID = accID;
        this.username = username;
        this.password = password;
        this.seller = seller;
        this.admin = admin;
    }

    

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Account{" + "accID=" + accID + ", username=" + username + ", password=" + password + ", seller=" + seller + ", admin=" + admin + '}';
    }
    

    }

    
