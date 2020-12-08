package com.dynamics.website.repository;

import com.dynamics.website.model.WorkshopUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopRepository extends CrudRepository<WorkshopUser, Long> {
    List<WorkshopUser> findByFirstName(String firstName);
}
