package com.example.nestApp_NewBackend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Guard")
public class Guard {


    @Id
    @GeneratedValue
    private int id;
    private int Guardnumber;
    private String name;
    private double salary;
    private String mobileNumber;
    private String userName;
    private String password;

    public Guard(int id, int guardNumber, String name, double salary, String mobileNumber, String userName, String password) {
        this.id = id;
        this.Guardnumber = guardNumber;
        this.name = name;
        this.salary = salary;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.password = password;
    }

    public Guard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuardnumber() {
        return Guardnumber;
    }

    public void setGuardnumber(int guardnumber) {
        Guardnumber = guardnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}