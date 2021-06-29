package com.dynamics.website.utils;

import com.dynamics.website.model.Branch;

import java.util.HashMap;
import java.util.Map;

public class UserUtils {
    public static Map<String , String> branch_map = new HashMap<String, String>() {
        {
            put("CS", Branch.CSE);
            put("IS", Branch.ISE);
            put("EC", Branch.ECE);
            put("EE", Branch.EEE);
            put("EI", Branch.EIE);
            put("TE", Branch.TEL);
            put("CH", Branch.CHEM);
            put("CV", Branch.CIVIL);
            put("BT", Branch.BIO);
            put("ME", Branch.MECH);
        }
    };

    public static String getBranchName(String key) {
        String branch = branch_map.get(key);
        return branch;
    }
}
