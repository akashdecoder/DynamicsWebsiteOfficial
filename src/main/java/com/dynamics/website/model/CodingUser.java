package com.dynamics.website.model;

import com.google.api.client.util.DateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public class CodingUser {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long coding_id;
//
//    @Column(nullable = false, length = 64)
//    private String firstName;
//
//    @Column(nullable = false, length = 64)
//    private String lastName;
//
//    @Column(nullable = false, length = 64)
//    private String year;
//
//    @Column(nullable = false, length = 64)
//    private String branch;
//
//    @Column(nullable = false, length = 64)
//    private String usn;
//
//    @Column(nullable = false, length = 64)
//    private String email;
//
//    @Column(nullable = false, length = 12)
//    private long contact;
//
//    @Column(nullable = false, length = 64)
//    private String event_name;
//
//    @Column(nullable = false, length = 150)
//    private String hack_id;

    private @Getter @Setter String coding_id;

    private @Getter @Setter String firstName;

    private @Getter @Setter String lastName;

    private @Getter @Setter String year;

    private @Getter @Setter String branch;

    private @Getter @Setter String usn;

    private @Getter @Setter String college;

    private @Getter @Setter String presentAddress;

    private @Getter @Setter String cityState;

    private @Getter @Setter String pincode;

    private @Getter @Setter String email;

    private @Getter @Setter long contact;

    private @Getter @Setter String event_name;

    private @Getter @Setter String hack_id;

    private @Getter @Setter String date;

    private @Getter @Setter String sentMail;

    private @Getter @Setter String idUrl;

    public CodingUser() {
    }

//    public CodingUser(String coding_id, String firstName, String lastName, String year, String branch, String usn, String college, String email, long contact, String event_name, String hack_id, String date, String sentMail, String idUrl) {
//        this.coding_id = coding_id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.year = year;
//        this.branch = branch;
//        this.usn = usn;
//        this.college = college;
//        this.email = email;
//        this.contact = contact;
//        this.event_name = event_name;
//        this.hack_id = hack_id;
//        this.date = date;
//        this.sentMail = sentMail;
//        this.idUrl = idUrl;
//    }

//    public String getEvent_name() {
//        return event_name;
//    }
//
//    public void setEvent_name(String event_name) {
//        this.event_name = event_name;
//    }
//
//    public String getCoding_id() {
//        return coding_id;
//    }
//
//    public void setCoding_id(String coding_id) {
//        this.coding_id = coding_id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getYear() {
//        return year;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }
//
//    public String getBranch() {
//        return branch;
//    }
//
//    public void setBranch(String branch) {
//        this.branch = branch;
//    }
//
//    public String getUsn() {
//        return usn;
//    }
//
//    public void setUsn(String usn) {
//        this.usn = usn;
//    }
//
//    public String getCollege() {
//        return college;
//    }
//
//    public void setCollege(String college) {
//        this.college = college;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public long getContact() {
//        return contact;
//    }
//
//    public void setContact(long contact) {
//        this.contact = contact;
//    }
//
//    public String getHack_id() {
//        return hack_id;
//    }
//
//    public void setHack_id(String hack_id) {
//        this.hack_id = hack_id;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getSentMail() {
//        return sentMail;
//    }
//
//    public void setSentMail(String sentMail) {
//        this.sentMail = sentMail;
//    }
//
//    public String getIdUrl() {
//        return idUrl;
//    }
//
//    public void setIdUrl(String idUrl) {
//        this.idUrl = idUrl;
//    }
}
