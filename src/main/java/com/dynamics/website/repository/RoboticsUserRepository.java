//package com.dynamics.website.repository;
//
//
//import com.dynamics.website.model.RoboticsUser;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface RoboticsUserRepository extends JpaRepository<RoboticsUser, Long> {
//    @Query("select r from RoboticsUser r where r.email = ?1")
//    public RoboticsUser findByEmail(String email);
//}
