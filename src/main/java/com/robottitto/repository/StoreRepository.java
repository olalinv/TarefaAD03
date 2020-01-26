package com.robottitto.repository;

import com.robottitto.dao.StoreDAO;
import com.robottitto.model.Store;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class StoreRepository {

    public static List<Store> getStores() throws FileNotFoundException, SQLException {
        return StoreDAO.getStores();
    }

    public static Store getStore(String storeName) throws FileNotFoundException, SQLException {
        return StoreDAO.getStore(storeName);
    }

    public static void addStore(Store store) throws FileNotFoundException, SQLException {
        StoreDAO.addStore(store);
    }

    public static void removeStore(String storeName) throws FileNotFoundException, SQLException {
        StoreDAO.removeStore(storeName);
    }

}
