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
public class Total {
    private int totalMoney;

    public Total() {
    }

    public Total(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return " totalMoney: " + totalMoney +"$" ;
    }
    
    
}
