package com.dynamics.website.repository;


import com.dynamics.website.model.CodingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CodingUserRepository extends JpaRepository<CodingUser, Long> {

    @Query("select c from CodingUser c where c.email = ?1")
    public CodingUser findByEmail(String email);

    @Query("select c from CodingUser c where c.hackid = ?1")
    public CodingUser findByHackid(String hackid);

    @Query("select c from CodingUser c where c.usn = ?1")
    public CodingUser findByUsn(String usn);

    @Query("select c from CodingUser c where c.firstName = ?1")
    public CodingUser findByFirstName(String name);

    public CodingUser findByFirstNameOrHackidOrUsnOrEmail(String firstName, String hackid, String usn, String email);
}
