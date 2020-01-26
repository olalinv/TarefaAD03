package com.robottitto.model;

import java.io.Serializable;

public class Employee implements Serializable {

    private int id;
    private String name;
    private String surname;
    private int hours;

    public Employee() {
    }

    public Employee(int id, String surname, int hours) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", hours='" + hours + '\'' +
                '}';
    }

}
