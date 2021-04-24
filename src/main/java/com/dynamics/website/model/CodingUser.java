package com.dynamics.website.model;


public class CodingUser {

    private long coding_id;

    private String firstName;

    private String lastName;

    private String year;

    private String branch;

    private String usn;

    private String email;

    private long contact;

    private String event_name;

    private String hack_id;

    public CodingUser() {
    }

    public CodingUser(long coding_id, String firstName, String lastName, String year, String branch, String usn,
                      String email, long contact, String event_name, String hack_id) {
        super();
        this.coding_id = coding_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.branch = branch;
        this.usn = usn;
        this.email = email;
        this.contact = contact;
        this.event_name = event_name;
        this.hack_id = hack_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public long getCoding_id() {
        return coding_id;
    }

    public void setCoding_id(long coding_id) {
        this.coding_id = coding_id;
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

    public String getHack_id() {
        return hack_id;
    }

    public void setHack_id(String hack_id) {
        this.hack_id = hack_id;
    }
}
