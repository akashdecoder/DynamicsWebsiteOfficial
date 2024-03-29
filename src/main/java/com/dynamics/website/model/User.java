package com.dynamics.website.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class User {

    private @Getter @Setter String user_id;

    private @Getter @Setter String firstName;

    private @Getter @Setter String lastName;

    private @Getter @Setter String year;

    private @Getter @Setter String branch;

    private @Getter @Setter String usn;

    private @Getter @Setter String email;

    private @Getter @Setter long contact;

    private @Getter @Setter String pLanguage;

    private @Getter @Setter int projects;

    private @Getter @Setter String groups;

//    private @Getter @Setter String dob;

    private @Getter @Setter String github;

    private @Getter @Setter String linkedin;

//    private @Getter @Setter String hackerrank;
//
//    private @Getter @Setter String leetcode;

    private @Getter @Setter String why;

    private @Getter @Setter String whys;

    private @Getter @Setter String about;

    private @Getter @Setter String fileUrl;

    private @Getter @Setter String category;

}
