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
public class Cart {
    private int cartId;
    private String name;
    private String image;
    private String title;
    private double price;
    private int amount;
    public Cart() {
    }

    public Cart(int cartId, String name, String image, String title, double price, int amount) {
        this.cartId = cartId;
        this.name = name;
        this.image = image;
        this.title = title;
        this.price = price;
        this.amount = amount;
    }

   

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    @Override
    public String toString() {
        return "Cart{" + "cartId=" + cartId + ", name=" + name + ", image=" + image + ", title=" + title + ", price=" + price + '}';
    }
    
    
}
