package com.robottitto.dao;

import com.robottitto.model.StoreProduct;
import com.robottitto.util.DBUtils;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreProductDAO {

    public static int getStoreProductStock(StoreProduct storeProduct) throws SQLException, FileNotFoundException {
        int quantity = 0;
        String sql = "SELECT * FROM STORE_PRODUCT WHERE STORE_ID = ? AND PRODUCT_ID = ? LIMIT 1";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, storeProduct.getStore().getId());
        pstmt.setInt(2, storeProduct.getProduct().getId());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            quantity = rs.getInt("PR_QUANTITY");
        }
        return quantity;
    }

    public static void addStoreProduct(StoreProduct storeProduct) throws SQLException, FileNotFoundException {
        String sql = "INSERT INTO STORE_PRODUCT(STORE_ID, PRODUCT_ID, PR_QUANTITY) VALUES(?, ?, ?)";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, storeProduct.getStore().getId());
        pstmt.setInt(2, storeProduct.getProduct().getId());
        pstmt.setDouble(3, storeProduct.getQuantity());
        pstmt.executeUpdate();
    }

    public static void updateStoreProduct(StoreProduct storeProduct) throws SQLException, FileNotFoundException {
        String sql = "UPDATE STORE_PRODUCT SET PR_QUANTITY = ? WHERE STORE_ID = ? AND PRODUCT_ID = ?";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setDouble(1, storeProduct.getQuantity());
        pstmt.setInt(2, storeProduct.getStore().getId());
        pstmt.setInt(3, storeProduct.getProduct().getId());
        pstmt.executeUpdate();
    }


    public static void removeStoreProduct(StoreProduct storeProduct) throws SQLException, FileNotFoundException {
        String sql = "DELETE FROM STORE_PRODUCT WHERE STORE_ID = ? AND PRODUCT_ID = ?";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, storeProduct.getStore().getId());
        pstmt.setInt(2, storeProduct.getProduct().getId());
        pstmt.executeUpdate();
    }

}
