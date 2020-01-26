package com.robottitto.dao;

import com.robottitto.model.Province;
import com.robottitto.util.DBUtils;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDAO {

    public static List<Province> getProvinces() throws SQLException, FileNotFoundException {
        List<Province> provinces = new ArrayList<Province>();
        String sql = "SELECT * FROM PROVINCE";
        Connection connection = DBUtils.connect();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Province province = new Province(rs.getInt("PROVINCE_ID"), rs.getString("NAME"));
            provinces.add(province);
        }
        return provinces;
    }

    public static void addProvince(Province province) throws SQLException, FileNotFoundException {
        String sql = "INSERT INTO PROVINCE(PROVINCE_ID, NAME) VALUES(?, ?)";
        Connection connection = DBUtils.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, province.getId());
        pstmt.setString(2, province.getName());
        pstmt.executeUpdate();
    }

}
