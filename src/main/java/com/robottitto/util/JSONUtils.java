package com.robottitto.util;

import com.google.gson.Gson;
import com.robottitto.model.Franchise;
import com.robottitto.model.Province;
import com.robottitto.model.Provinces;

import java.io.*;
import java.util.List;

public class JSONUtils {

    public static final String FRANCHISE_JSON = "franchise.json";
    public static final String PROVINCES_JSON = "provinces.json";

    public static void generateFranchise(Franchise franchise) throws IOException {
        String json = new Gson().toJson(franchise);
        BufferedWriter writer = new BufferedWriter(new FileWriter(FRANCHISE_JSON));
        writer.write(json);
        writer.close();
        System.out.println("Xerouse o arquivo " + FRANCHISE_JSON);
    }

    public static Franchise readFranchise() throws FileNotFoundException {
        Franchise franchise = new Gson().fromJson(new FileReader(FRANCHISE_JSON), Franchise.class);
        return franchise == null ? new Franchise() : franchise;
    }

    public static List<Province> readProvinces() throws FileNotFoundException {
        Provinces provinces = new Gson().fromJson(new FileReader(PROVINCES_JSON), Provinces.class);
        return provinces.getProvinces();
    }

}
