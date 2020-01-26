package com.robottitto.dao;

import com.robottitto.model.Customer;
import com.robottitto.util.DBUtils;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public static List<Customer> getCustomers() throws SQLException, FileNotFoundException {
        List<Customer> customers = new ArrayList<Customer>();
        String sql = "SELECT * FROM CUSTOMER";
        Connection connection = DBUtils.connect();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Customer customer = new Customer(
                    rs.getInt("CUSTOMER_ID"),
                    rs.getString("NAME"),
                    rs.getString("SURNAME"),
                    rs.getString("EMAIL")
            );
            customers.add(customer);
        }
        return customers;
    }

    public static void addCustomer(Customer customer) throws SQLException, FileNotFoundException {
        String sql = "INSERT INTO CUSTOMER(NAME, SURNAME, EMAIL) VALUES(?, ?, ?)";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, customer.getName());
        pstmt.setString(2, customer.getSurname());
        pstmt.setString(3, customer.getEmail());
        pstmt.executeUpdate();
    }

    public static void removeCustomer(String customerName) throws SQLException, FileNotFoundException {
        String sql = "DELETE FROM CUSTOMER WHERE NAME = ?";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, customerName);
        pstmt.executeUpdate();
    }

}
