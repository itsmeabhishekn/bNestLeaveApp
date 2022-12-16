package com.example.nestApp_NewBackend.dao;

import com.example.nestApp_NewBackend.model.guestLogs;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface GuestDao extends CrudRepository<guestLogs,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE `guest` SET `logout`=:logout,`minutes`=:minutes WHERE `guest_id` =:guest_id AND `date`=:date",nativeQuery = true)
    void updateGuestLog(@Param("logout") String logout, @Param("minutes") Integer minutes, @Param("guest_id") Integer guest_id, @Param("date") String date);

    @Query(value = "SELECT `id`, `address`, `date`, `guest_id`, `login`, `logout`, `minutes`, `name` FROM `guest` WHERE `date` =:date AND `guest_id`=:guest_id",nativeQuery = true)
    List<guestLogs> searchLog(@Param("date") String date, @Param("guest_id") Integer guest_id);

    @Query(value = "SELECT `id`, `address`, `date`, `guest_id`, `login`, `logout`, `minutes`, `name` FROM `guest` WHERE `date`=:date",nativeQuery = true)
    List<Map<String,String>> todayLog1Maps(@Param("date") String date);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `guest` SET `date`=:date,`login`=:login WHERE `guest_id`=:guest_id",nativeQuery = true)
    void updateLogin(@Param("date") String date, @Param("login") String login, @Param("guest_id") Integer guest_id);

}
