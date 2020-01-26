package com.robottitto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Franchise implements Serializable {

    private List<Customer> customers;
    private List<Store> stores;

    public Franchise() {
        this.customers = new ArrayList<Customer>();
        this.stores = new ArrayList<Store>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    @Override
    public String toString() {
        return "Franchise{" +
                "customers=" + customers +
                ", stores=" + stores +
                '}';
    }
}
