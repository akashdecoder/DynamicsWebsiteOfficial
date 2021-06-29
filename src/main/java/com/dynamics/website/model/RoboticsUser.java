package com.dynamics.website.model;

import javax.persistence.*;

@Entity
@Table(name = "robotics")
public class RoboticsUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long robotics_id;

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

    @Column(nullable = false, length = 64)
    private String event_name;

    public RoboticsUser() {
    }

    public RoboticsUser(long robotics_id, String firstName, String lastName, String year, String branch, String usn, String email, long contact, String event_name) {
        super();
        this.robotics_id = robotics_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.branch = branch;
        this.usn = usn;
        this.email = email;
        this.contact = contact;
        this.event_name = event_name;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public long getCoding_id() {
        return robotics_id;
    }

    public void setCoding_id(long coding_id) {
        this.robotics_id = coding_id;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }
}
