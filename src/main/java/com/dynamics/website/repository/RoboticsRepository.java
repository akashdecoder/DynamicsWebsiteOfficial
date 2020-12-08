package com.dynamics.website.repository;

import com.dynamics.website.model.RoboticsUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoboticsRepository extends CrudRepository<RoboticsUser, Long> {
    List<RoboticsUser> findByFirstName(String firstName);
}
