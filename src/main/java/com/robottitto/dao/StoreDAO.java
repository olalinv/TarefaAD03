package com.robottitto.dao;

import com.robottitto.model.Store;
import com.robottitto.util.DBUtils;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreDAO {

    public static List<Store> getStores() throws SQLException, FileNotFoundException {
        List<Store> stores = new ArrayList<Store>();
        String sql = "SELECT * FROM STORE";
        Connection connection = DBUtils.connect();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Store store = new Store(
                    rs.getInt("STORE_ID"),
                    rs.getString("NAME"),
                    rs.getString("CITY"),
                    rs.getInt("PROVINCE_ID")
            );
            stores.add(store);
        }
        return stores;
    }

    public static Store getStore(String storeName) throws SQLException, FileNotFoundException {
        Store store = new Store();
        String sql = "SELECT * FROM STORE WHERE NAME = ? LIMIT 1";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, storeName);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            store.setId(rs.getInt("STORE_ID"));
            store.setName(rs.getString("NAME"));
            store.setCity(rs.getString("CITY"));
            store.setProvinceId(rs.getInt("PROVINCE_ID"));
        }
        return store;
    }

    public static void addStore(Store store) throws SQLException, FileNotFoundException {
        String sql = "INSERT INTO STORE(NAME, CITY, PROVINCE_ID) VALUES(?, ?, ?)";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, store.getName());
        pstmt.setString(2, store.getCity());
        pstmt.setInt(3, store.getProvinceId());
        pstmt.executeUpdate();
    }

    public static void removeStore(String storeName) throws SQLException, FileNotFoundException {
        String sql = "DELETE FROM STORE WHERE NAME = ?";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, storeName);
        pstmt.executeUpdate();
    }

}
