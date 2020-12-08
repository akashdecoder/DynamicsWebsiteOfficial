package com.dynamics.website.model;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Table
public class AppUser {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = false)
    private long userId;

    @Column
    private String userName;

    @Column
    private String firstName;

    @Column
    private String lastName;


//    private boolean enabled;

    @Column
    private String year;

    @Column
    private String branch;

    @Column
    private String usn;

    @Column
    private String email;

    @Column
    private long contact;

    public AppUser() {

    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public AppUser(long userId, String userName, String firstName, String lastName, String year, //
                   String usn, String email, String branch, Long contact) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.usn = usn;
        this.email = email;
        this.branch = branch;
        this.contact = contact;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }
    //    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

}