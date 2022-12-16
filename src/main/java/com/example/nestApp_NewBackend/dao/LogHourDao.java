package com.example.nestApp_NewBackend.dao;

import com.example.nestApp_NewBackend.model.logHours;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LogHourDao extends CrudRepository<logHours,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE `log_hours` SET `logout`=:logout, `minutes`=:minutes  WHERE `emp_id`=:emp_id AND `date`=:date",nativeQuery = true)
    void updateLog(@Param("logout") String logout,@Param("minutes") Integer minutes,@Param("emp_id") Integer emp_id,@Param("date") String date);

    @Query(value = "SELECT `id`, `date`, `emp_id`, `login`, `logout`, `minutes` FROM `log_hours` WHERE `date` =:date AND `emp_id`=:emp_id",nativeQuery = true)
    List<logHours> searchLog(@Param("date") String date, @Param("emp_id") Integer emp_id);

    @Query(value = "SELECT l.`id`, l.`date`, l.`emp_id`, l.`login`, l.`logout`, l.`minutes`,e.name,e.designation,e.employee_code FROM `log_hours` l JOIN employee e on l.emp_id=e.employee_code ",nativeQuery = true)
    List<Map<String,String>> todayLogMaps();

    @Query(value = "SELECT l.`id`, l.`date`, l.`emp_id`, l.`login`, l.`logout`, l.`minutes`,e.name,e.designation,e.employee_code FROM `log_hours` l JOIN employee e on l.emp_id=e.employee_code WHERE l.`date`=:date ",nativeQuery = true)
    List<Map<String,String>> todayLog1Maps(@Param("date") String date);

}
