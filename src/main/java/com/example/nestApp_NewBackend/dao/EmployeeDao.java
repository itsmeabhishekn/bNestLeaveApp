package com.example.nestApp_NewBackend.dao;

import com.example.nestApp_NewBackend.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;


public interface EmployeeDao extends CrudRepository<Employee, Integer> {



    @Query(value = "SELECT `id`, `designation`, `employee_code`, `mobile_number`, `name`, `password`, `salary`, `user_name` FROM `employee` WHERE `employee_code`=:employee_code",nativeQuery = true)
    List<Employee> EmpSearch(@Param("employee_code") Integer employee_code);


    @Query(value = "SELECT `id`,`designation`, `employee_code`, `mobile_number`, `name`, `password`, `salary`, `user_name` FROM `employee` WHERE `user_name`=:user_name AND `password`=:password",nativeQuery = true)
    List<Employee> LoginEmp(@Param("user_name") String user_name, @Param("password") String password);

    @Query(value = "SELECT e.`id`, e.`designation`, e.`employee_code`, e.`mobile_number`, e.`name`, e.`password`, e.`salary`, e.`user_name`,l.login,l.logout,l.minutes FROM `employee` e JOIN log_hours l ON e.employee_code=l.emp_id  WHERE l.date=:date",nativeQuery = true)
    List<Map<String,String>> findEmployees(@Param("date") String date);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `employee` WHERE `id`=:id",nativeQuery = true)
    void EmpDelete(@Param("id") Integer id);



    @Query(value = "SELECT `id`, `designation`, `employee_code`, `mobile_number`, `name`, `password`, `salary`, `user_name` FROM `employee` WHERE `employee_code` NOT IN (SELECT  `empid` FROM `leaves` WHERE :date  BETWEEN `from` AND `to`);",nativeQuery = true)
    List<Employee> findEmployeesLeaves(@Param("date") String date);
}
