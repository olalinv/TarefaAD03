package com.robottitto.repository;

import com.robottitto.dao.CustomerDAO;
import com.robottitto.model.Customer;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class CustomerRepository {

    public static List<Customer> getCustomers() throws FileNotFoundException, SQLException {
        return CustomerDAO.getCustomers();
    }

    public static void addCustomer(Customer customer) throws FileNotFoundException, SQLException {
        CustomerDAO.addCustomer(customer);
    }

    public static void removeCustomer(String customerName) throws FileNotFoundException, SQLException {
        CustomerDAO.removeCustomer(customerName);
    }

}
