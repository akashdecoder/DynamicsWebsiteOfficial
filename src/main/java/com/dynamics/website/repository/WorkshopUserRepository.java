//package com.dynamics.website.repository;
//
//import com.dynamics.website.model.WorkshopUser;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface WorkshopUserRepository extends JpaRepository<WorkshopUser,Long> {
//
//    @Query("select w from WorkshopUser w where w.email = ?1")
//    public WorkshopUser findByEmail(String email);
//}
