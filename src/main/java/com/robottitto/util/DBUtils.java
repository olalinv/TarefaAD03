package com.robottitto.util;

import com.robottitto.dao.ProvinceDAO;
import com.robottitto.model.Province;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class DBUtils {

    private static final String DB_NAME = "stores.db";
    private static final String DB_FILE = "jdbc:sqlite:" + DB_NAME;
    private static final String INIT_SQL_FILE = "db_init.sql";
    private static Connection connection = null;
    private static Properties properties = new Properties();

    private static Connection create() throws FileNotFoundException, SQLException {
        properties.setProperty("foreign_keys", "true");
        connection = DriverManager.getConnection(DB_FILE, properties);
        if (null != connection) {
            initialize();
            insertProvinces();
        }
        return connection;
    }

    public static Connection connect() throws SQLException, FileNotFoundException {
        File file = new File(DB_NAME);
        if (!file.exists()) {
            connection = create();
        } else {
            connection = DriverManager.getConnection(DB_FILE, properties);
        }
        return connection;
    }

    public static void close() throws SQLException {
        if (null != connection) {
            connection.close();
        }
    }

    public static void initialize() throws FileNotFoundException {
        // Initialize the script runner
        ScriptRunner sr = new ScriptRunner(connection);
        // Creating a reader object
        Reader reader = new BufferedReader(new FileReader(INIT_SQL_FILE));
        // Running the script
        sr.setEscapeProcessing(false);
        sr.runScript(reader);
    }

    public static void insertProvinces() throws FileNotFoundException, SQLException {
        List<Province> provinces = JSONUtils.readProvinces();
        for (Province province : provinces) {
            ProvinceDAO.addProvince(province);
        }
    }

}
