package com.dynamics.website.repository;

import com.dynamics.website.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {

    @Query("select u from AppUser u where u.email = ?1")
    public AppUser findByEmail(String email);
}
