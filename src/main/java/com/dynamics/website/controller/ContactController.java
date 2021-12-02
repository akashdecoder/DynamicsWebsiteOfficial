//package com.dynamics.website.controller;
//
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.mail.SimpleMailMessage;
////import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class ContactController {
//
////    @Autowired
////    private JavaMailSender mailSender;
//
//    @GetMapping("/dynamics/contactus")
//    public String showContact() {
//        return "contactus.html";
//    }
//
//    @PostMapping("/dynamics/contactus")
//    public String sendMessage(HttpServletRequest request) {
////        String fullName = request.getParameter("fullName");
////        String email = request.getParameter("email");
////        String phone = request.getParameter("phone");
////        String message = request.getParameter("message");
////        System.out.println(email);
////
////        SimpleMailMessage mailMessage = new SimpleMailMessage();
////
////        mailMessage.setFrom(email);
////        mailMessage.setTo("dynamicsPOC19.sit@gmail.com");
////
////        String mailSubject = fullName +  " has sent a message";
////        String mailContent = "Sender name: " + fullName + "\n";
////        mailContent += "Sender E-mail: " + email + "\n";
////        mailContent += "Sender Phone: " + phone + "\n";
////        mailContent += "Content: " + message + "\n";
////
////        mailMessage.setSubject(mailSubject);
////        mailMessage.setText(mailContent);
////
////        mailSender.send(mailMessage);
////        System.out.println("Mail Sent");
//
//        return "messsage.html";
//    }
//}
