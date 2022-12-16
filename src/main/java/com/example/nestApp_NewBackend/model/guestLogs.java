package com.example.nestApp_NewBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "guest")
public class guestLogs {
    @Id
    @GeneratedValue()
    private int id;
    private int guest_id;
    private String name;
    private String address;
    private String date;
    private String login;
    private String logout;
    private  int minutes;

    public guestLogs(int id, int guest_id, String name, String address, String date, String login, String logout, int minutes) {
        this.id = id;
        this.guest_id = guest_id;
        this.name = name;
        this.address = address;
        this.date = date;
        this.login = login;
        this.logout = logout;
        this.minutes = minutes;
    }

    public guestLogs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
