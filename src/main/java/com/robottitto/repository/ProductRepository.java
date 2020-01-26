package com.robottitto.repository;

import com.robottitto.dao.ProductDAO;
import com.robottitto.model.Product;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class ProductRepository {

    public static void addProduct(Product product) throws FileNotFoundException, SQLException {
        ProductDAO.addProduct(product);
    }

    public static void removeProduct(String productName) throws FileNotFoundException, SQLException {
        ProductDAO.removeProduct(productName);
    }

    public static List<Product> getProducts() throws FileNotFoundException, SQLException {
        return ProductDAO.getProducts();
    }

    public static List<Product> getProductsByStore(String storeName) throws FileNotFoundException, SQLException {
        return ProductDAO.getProductsByStore(storeName);
    }

    public static Product getProduct(String productName) throws FileNotFoundException, SQLException {
        return ProductDAO.getProduct(productName);
    }

}
