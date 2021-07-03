package com.dynamics.website.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "registration")
public class AppUser {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false, length = 64)
    private String firstName;

    @Column(nullable = false, length = 64)
    private String lastName;

    @Column(nullable = false, length = 64)
    private String year;

    @Column(nullable = false, length = 64)
    private String branch;

    @Column(nullable = false, length = 64)
    private String usn;

    @Column(nullable = false, length = 64)
    private String email;

    @Column(nullable = false, length = 12)
    private long contact;

    @Column(nullable = false, length = 200)
    private String fileUrl;

    public AppUser() {

    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public AppUser(String firstName, String lastName, String year, String branch, String usn, String email, long contact, String fileUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.branch = branch;
        this.usn = usn;
        this.email = email;
        this.contact = contact;
        this.fileUrl = fileUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}