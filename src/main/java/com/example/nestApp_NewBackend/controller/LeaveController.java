package com.example.nestApp_NewBackend.controller;

import com.example.nestApp_NewBackend.dao.LeaveDao;
import com.example.nestApp_NewBackend.model.Leaves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    LeaveDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLeaves",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> addLeaves(@RequestBody Leaves leaves){

        HashMap<String,String> map = new HashMap<>();
        System.out.println(leaves.toString());
        LocalDate from = LocalDate.parse(String.valueOf(leaves.getFrom()));
        LocalDate to = LocalDate.parse(String.valueOf(leaves.getTo()));
        long diffInDays = ChronoUnit.DAYS.between(from, to);
        leaves.setDays((int) diffInDays+1);
        dao.save(leaves);
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewLeaves")
    public List<Leaves> viewLeaves(){
        return (List<Leaves>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/Leaves")
    public List<Map<String,String>> Leaves(){
        return (List<Map<String, String>>) dao.Leaves();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchLeaves",consumes = "application/json",produces = "application/json")
    public List<Leaves> searchLeaves(@RequestBody  Leaves leaves){


        return (List<Leaves>) dao.searchLeaves(leaves.getEmpid());
    }




    @CrossOrigin(origins = "*")
    @PostMapping(path = "/editLeaves",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> editLeaves(@RequestBody Leaves leaves){

        HashMap<String,String> map = new HashMap<>();

        dao.updateLeave(leaves.getStatus(),leaves.getRemarks(),leaves.getId());
        map.put("status","success");
        return map;
    }


}
