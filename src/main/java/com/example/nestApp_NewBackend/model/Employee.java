package com.example.nestApp_NewBackend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {


    @Id
    @GeneratedValue
    private int id;
    private int employeeCode;
    private String name;
    private String designation;
    private double salary;
    private String mobileNumber;
    private String userName;
    private String password;

    public Employee(int id, int employeeCode, String name, String designation, double salary,  String mobileNumber, String userName, String password) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.password = password;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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
