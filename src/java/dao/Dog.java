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
public class Dog implements Comparable<Dog>{
    private int id;
    private String name;
    private String image;
    private double price;
    private String title;
    private String description;
    private String alimentation;

    public Dog() {
    }

    public Dog(int id, String name, String image, double price, String title, String description, String alimentation) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
        this.alimentation = alimentation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlimentation() {
        return alimentation;
    }

    public void setAlimentation(String alimentation) {
        this.alimentation = alimentation;
    }

    @Override
    public String toString() {
        return "Dog{" + "id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", title=" + title + ", description=" + description + ", alimentation=" + alimentation + '}';
    }

    @Override
    public int compareTo(Dog o) {
        return this.id -  o.id;
    }
    
    
    
    
}
