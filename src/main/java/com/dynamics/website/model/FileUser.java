package com.dynamics.website.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileUser {

    private MultipartFile file;

    private File file1;

    private String name;

    private String usn;

    private String email;

    public FileUser() {
    }

    public FileUser(MultipartFile file, File file1, String name, String usn, String email) {
        this.file = file;
        this.file1 = file1;
        this.name = name;
        this.usn = usn;
        this.email = email;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public File getFile1() {
        return file1;
    }

    public void setFile1(File file1) {
        this.file1 = file1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
