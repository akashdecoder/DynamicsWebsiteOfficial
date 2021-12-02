//package com.dynamics.website.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "file_users")
//public class FileDb {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(nullable = false, length = 200)
//    private String fileUrl;
//
//    @Column(nullable = false, length = 30)
//    private String usn;
//
//    @Column(nullable = false, length = 64)
//    private String name;
//
//    public FileDb() {
//    }
//
//    public FileDb(String fileUrl, String usn, String name) {
//        this.fileUrl = fileUrl;
//        this.usn = usn;
//        this.name = name;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getFileUrl() {
//        return fileUrl;
//    }
//
//    public void setFileUrl(String fileUrl) {
//        this.fileUrl = fileUrl;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
