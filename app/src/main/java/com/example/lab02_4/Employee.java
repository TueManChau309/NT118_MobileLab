package com.example.lab02_4;

public class Employee {
    private String Id;
    private String Name;
    private boolean isManager;
    public Employee(String id, String name) {
        Id = id;
        Name = name;
    }

    public Employee() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFullName() {
        return Name;
    }

    public void setFullName(String name) {
        Name = name;
    }

    public boolean isManager() {
        return isManager;
    }
    public void setManager(boolean manager) {
        isManager = manager;
    }
}
