package com.example.nestApp_NewBackend.controller;

import com.example.nestApp_NewBackend.dao.EmployeeDao;
import com.example.nestApp_NewBackend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemp",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> add(@RequestBody Employee e){
        HashMap<String,String> map = new HashMap<>();
        dao.save(e);
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/emplogin",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> login(@RequestBody Employee e){
        HashMap<String, String> map = new HashMap<String, String>();
        List<Employee> emp= dao.LoginEmp(e.getUserName(),e.getPassword());
        if (emp.size() != 0) {
            map.put("id",String.valueOf( emp.get(0).getId()));
            map.put("status","success");
            map.put("employeeCode",String.valueOf( emp.get(0).getEmployeeCode()));
        }else {
            map.put("status","failed");
        }
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/empview")
    public List<Employee> view(){
        return (List<Employee>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/empsearch",consumes = "application/json",produces = "application/json")
    public List<Employee> search(@RequestBody Employee employee){
        return (List<Employee>) dao.EmpSearch(employee.getEmployeeCode());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/empdelete",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> delete(@RequestBody Employee employee) {
        HashMap<String, String> map = new HashMap<>();
        dao.EmpDelete(employee.getId());
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewLeavesEmp")
    public List<Employee> viewLeaves(){
        LocalDate ld1=LocalDate.now();
        return (List<Employee>) dao.findEmployeesLeaves(String.valueOf(ld1));
    }

}
