package com.example.nestApp_NewBackend.controller;


import com.example.nestApp_NewBackend.dao.LogHourDao;
import com.example.nestApp_NewBackend.model.logHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LogController {

    @Autowired
    LogHourDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLog",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> addLog(@RequestBody logHours log) {
        HashMap<String, String> map = new HashMap<>();
        LocalTime lt1 = LocalTime.now();
        LocalDate ld1=LocalDate.now();
        log.setLogin(String.valueOf(lt1));
        log.setDate(String.valueOf(ld1));
        List<logHours> log1=dao.searchLog(log.getDate(),log.getEmp_id());
        if (log1.size() ==0) {
        dao.save(log);}
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/editLog",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> editLog(@RequestBody logHours log) {
        HashMap<String, String> map = new HashMap<>();
        LocalTime lt1 = LocalTime.now();
        LocalDate ld1=LocalDate.now();
        log.setLogout(String.valueOf(lt1));
        log.setDate(String.valueOf(ld1));
        List<logHours> log1=dao.searchLog(log.getDate(),log.getEmp_id());
        LocalTime lt2 = LocalTime.parse(log1.get(0).getLogin());
        int minutes= (int) lt2.until(lt1, ChronoUnit.MINUTES);
        System.out.println(minutes);
        dao.updateLog(log.getLogout(),minutes, log.getEmp_id(),log.getDate());
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/todayLog")
    public List<Map<String,String>> todayLOog(){
        return  dao.todayLogMaps();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/dateLog",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> todayLog(@RequestBody logHours log){
        return  dao.todayLog1Maps(log.getDate());
    }

}
