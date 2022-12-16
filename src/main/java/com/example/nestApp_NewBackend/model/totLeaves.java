package com.example.nestApp_NewBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "totLeaves")
public class totLeaves {
    @Id
    @GeneratedValue()
    private Integer id;
    private Integer emp_id;
    private Integer year;
    private  Integer casual_leaves;
    private Integer sick_leave;
    private Integer special_leave;

    public totLeaves(Integer id, Integer emp_id, Integer year, Integer casual_leaves, Integer sick_leave, Integer special_leave) {
        this.id = id;
        this.emp_id = emp_id;
        this.year = year;
        this.casual_leaves = casual_leaves;
        this.sick_leave = sick_leave;
        this.special_leave = special_leave;
    }

    public totLeaves() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCasual_leaves() {
        return casual_leaves;
    }

    public void setCasual_leaves(Integer casual_leaves) {
        this.casual_leaves = casual_leaves;
    }

    public Integer getSick_leave() {
        return sick_leave;
    }

    public void setSick_leave(Integer sick_leave) {
        this.sick_leave = sick_leave;
    }

    public Integer getSpecial_leave() {
        return special_leave;
    }

    public void setSpecial_leave(Integer special_leave) {
        this.special_leave = special_leave;
    }
}
