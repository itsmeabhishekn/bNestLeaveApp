package com.example.nestApp_NewBackend.dao;

import com.example.nestApp_NewBackend.model.Employee;
import com.example.nestApp_NewBackend.model.Guard;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface GuardDao extends CrudRepository<Guard, Integer> {
    @Query(value = "SELECT `id`, `guardnumber`, `mobile_number`, `name`, `password`, `salary`, `user_name` FROM `guard` WHERE `user_name`=:user_name AND `password`=:password",nativeQuery = true)
    List<Guard> passwordCheck(@Param("user_name") String user_name, @Param("password") String password);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `guard` WHERE `id`=:id",nativeQuery = true)
    void deleteGuard(@Param("id") Integer id);

    @Query(value = "SELECT `id`, `guardnumber`, `mobile_number`, `name`, `password`, `salary`, `user_name` FROM `guard` WHERE `guardnumber`=:guardnumber",nativeQuery = true)
    List<Guard> searchGuards(@Param("guardnumber") Integer guardnumber);

}
