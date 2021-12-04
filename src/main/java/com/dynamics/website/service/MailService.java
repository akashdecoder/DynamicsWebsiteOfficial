package com.dynamics.website.service;

import com.dynamics.website.model.CodingUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MailService
{

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(CodingUser codingUser)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("dynamicspoc19.cse@sit.ac.in");
        mailMessage.setTo(codingUser.getEmail());

        String mailSubject = "CODE ARENA 2021 Registration Success";
        String mailContent = "Thank You " + "<b>" +  codingUser.getFirstName() + " " + codingUser.getLastName() + "</b>" +" for registering to CODE ARENA 2021.\n\nKeep in touch to know more updates.";
        mailContent = mailContent + "\n\nWith Regards,\nDynamics\n(Project Oriented Community)";

        mailMessage.setSubject(mailSubject);
        mailMessage.setText(mailContent);

        mailSender.send(mailMessage);
    }
}
