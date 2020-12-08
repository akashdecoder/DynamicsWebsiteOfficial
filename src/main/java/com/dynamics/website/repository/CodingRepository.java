package com.dynamics.website.repository;

import com.dynamics.website.model.CodingUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodingRepository extends CrudRepository<CodingUser, Long> {
    List<CodingUser> findByFirstName(String firstName);
}
