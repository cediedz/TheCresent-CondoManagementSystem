package com.admin.usermanagement.bean;

public class User {
    private int id;
    private String name;
    private String email;
    private String unitNumber;
    
    public User(String name, String email, String unitNumber) {
        this.name = name;
        this.email = email;
        this.unitNumber = unitNumber;
    }

    public User(int id, String name, String email, String unitNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.unitNumber = unitNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }
}
