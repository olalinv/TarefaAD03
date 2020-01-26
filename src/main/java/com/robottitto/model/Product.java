package com.robottitto.model;

import java.io.Serializable;

public class Product implements Serializable {

    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(int id, String description, double price) {
        this.id = id;
        this.name = description;
        this.price = price;
    }

    public Product(int id, String description, double price, int quantity) {
        this.id = id;
        this.name = description;
        this.price = price;
        this.quantity = quantity;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

}
