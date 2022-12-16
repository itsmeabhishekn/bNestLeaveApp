package com.example.nestApp_NewBackend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "logHours")
public class logHours {
    @Id
    @GeneratedValue()
    private int id;
    private int emp_id;
    private String date;
    private String login;
    private String logout;
    private  int minutes;

    public logHours() {
    }

    public logHours(int id, int emp_id, String date, String login, String logout, int minutes) {
        this.id = id;
        this.emp_id = emp_id;
        this.date = date;
        this.login = login;
        this.logout = logout;
        this.minutes = minutes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
