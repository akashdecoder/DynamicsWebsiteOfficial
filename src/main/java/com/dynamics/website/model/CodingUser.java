package com.dynamics.website.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class CodingUser {

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

    private @Getter @Setter String hack_id;

    private @Getter @Setter String date;

    private @Getter @Setter String sentMail;


}
