package com.robottitto.model;

import java.io.Serializable;
import java.util.List;

public class Store implements Serializable {

    private int id;
    private String name;
    private String city;
    private int provinceId;
    private List<Product> products;
    private List<Employee> employees;

    public Store() {
    }

    public Store(int id, String name, String city, int provinceId) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.provinceId = provinceId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", products=" + products +
                ", employees=" + employees +
                '}';
    }

}
