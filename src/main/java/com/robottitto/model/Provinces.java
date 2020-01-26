package com.robottitto.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Provinces implements Serializable {

    @SerializedName("provincias")
    private List<Province> provinces = new ArrayList<Province>();

    public Provinces() {
    }

    public Provinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

}
