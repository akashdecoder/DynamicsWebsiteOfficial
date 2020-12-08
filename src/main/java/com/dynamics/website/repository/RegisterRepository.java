package com.dynamics.website.repository;

import com.dynamics.website.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRepository extends CrudRepository<AppUser, Long> {
    List<AppUser> findByUserName(String username);
}
