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
public class AccountInformation {
    private int inforID;
    private String name;
    private String gender;
    private String email;
    private String address;
    private String phone;
    private int seller;
    private int admin;

    public AccountInformation() {
    }

    public AccountInformation(int inforID, String name, String gender, String email, String address, String phone, int seller, int admin) {
        this.inforID = inforID;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.seller = seller;
        this.admin = admin;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getInforID() {
        return inforID;
    }

    public void setInforID(int inforID) {
        this.inforID = inforID;
    }

    @Override
    public String toString() {
        return "AccountInformation{" + "inforID=" + inforID + ", name=" + name + ", gender=" + gender + ", email=" + email + ", address=" + address + ", phone=" + phone + ", seller=" + seller + ", admin=" + admin + '}';
    }
    

    
    
    
}
