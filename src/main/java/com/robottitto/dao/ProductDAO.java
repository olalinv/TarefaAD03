package com.robottitto.dao;

import com.robottitto.model.Product;
import com.robottitto.util.DBUtils;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static List<Product> getProducts() throws SQLException, FileNotFoundException {
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT * FROM PRODUCT";
        Connection connection = DBUtils.connect();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Product product = new Product(
                    rs.getInt("PRODUCT_ID"),
                    rs.getString("NAME"),
                    rs.getFloat("PRICE")
            );
            products.add(product);
        }
        return products;
    }

    public static List<Product> getProductsByStore(String storeName) throws SQLException, FileNotFoundException {
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT * FROM STORE_PRODUCT a, PRODUCT b, STORE c WHERE a.PRODUCT_ID = b.PRODUCT_ID AND a.STORE_ID = c.STORE_ID AND c.NAME = ?";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, storeName);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Product product = new Product(
                    rs.getInt("PRODUCT_ID"),
                    rs.getString("NAME"),
                    rs.getFloat("PRICE"),
                    rs.getInt("PR_QUANTITY")
            );
            products.add(product);
        }
        return products;
    }

    public static Product getProduct(String productName) throws SQLException, FileNotFoundException {
        Product product = new Product();
        String sql = "SELECT * FROM PRODUCT WHERE NAME = ? LIMIT 1";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, productName);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            product.setId(rs.getInt("PRODUCT_ID"));
            product.setName(rs.getString("NAME"));
            product.setPrice(rs.getDouble("PRICE"));
        }
        return product;
    }

    public static void addProduct(Product product) throws SQLException, FileNotFoundException {
        String sql = "INSERT INTO PRODUCT(NAME, PRICE) VALUES(?, ?)";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, product.getName());
        pstmt.setDouble(2, product.getPrice());
        pstmt.executeUpdate();
    }

    public static void removeProduct(String productName) throws SQLException, FileNotFoundException {
        String sql = "DELETE FROM PRODUCT WHERE NAME = ?";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, productName);
        pstmt.executeUpdate();
    }

}
