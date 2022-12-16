package com.example.nestApp_NewBackend.dao;

import com.example.nestApp_NewBackend.model.totLeaves;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TotalLeavesDao extends CrudRepository<totLeaves,Integer> {
    @Query(value = "SELECT `id`, `casual_leaves`, `emp_id`, `sick_leave`, `special_leave`, `year` FROM `tot_leaves` WHERE `emp_id`=:emp_id",nativeQuery = true)
    List<totLeaves> searchTotalLeavesEmployees(@Param("emp_id") Integer emp_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `tot_leaves` SET `casual_leaves`=`casual_leaves`-:casual_leaves,`sick_leave`=`sick_leave`-:sick_leave ,`special_leave`=`special_leave`-:special_leave WHERE `emp_id`=:emp_id AND `year`=:year",nativeQuery = true)
    void editLeaves(@Param("casual_leaves") Integer casual_leaves,@Param("sick_leave") Integer sick_leave,@Param("special_leave") Integer special_leave,@Param("emp_id") Integer emp_id,@Param("year") Integer year);
}
