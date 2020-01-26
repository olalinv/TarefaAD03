package com.robottitto.repository;

import com.robottitto.dao.ProvinceDAO;
import com.robottitto.model.Province;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class ProvinceRepository {

    public static List<Province> getProvinces() throws FileNotFoundException, SQLException {
        return ProvinceDAO.getProvinces();
    }

}
