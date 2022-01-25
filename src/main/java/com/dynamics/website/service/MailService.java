package com.dynamics.website.service;

import com.dynamics.website.model.CodingUser;
import com.dynamics.website.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

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
        String mailContent = "Thank You "  +  codingUser.getFirstName() + " " + codingUser.getLastName() + " for registering to CODE ARENA 2021.\n\nKeep in touch to know more updates.";
        mailContent = mailContent + "\n\nWith Regards,\nDynamics\n(Project Oriented Community)";

        mailMessage.setSubject(mailSubject);
        mailMessage.setText(mailContent);

        mailSender.send(mailMessage);
    }

    public void sendEmailWithAttachment(User user)
    {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
                mimeMessage.setRecipient(Message.RecipientType.CC, new InternetAddress("1si18cs008@sit.ac.in"));
                mimeMessage.setFrom(new InternetAddress("dynamicspoc19.cse@sit.ac.in"));
                mimeMessage.setSubject("Dynamics Project Oriented Community Recruitments 2022 Registration Success");


                String fileName = "";

                if(user.getYear().equals("1st Year")) {
                    fileName = "F:\\REST_Frameworks\\DynamicsWebsiteOfficial\\src\\main\\resources\\generatedPDFs\\first_years" + File.separator + user.getUsn() + "_" + user.getFirstName() + user.getLastName() +".pdf";
                } else if(user.getYear().equals("2nd Year")) {
                    fileName = "F:\\REST_Frameworks\\DynamicsWebsiteOfficial\\src\\main\\resources\\generatedPDFs\\second_years" + File.separator + user.getUsn() + "_" + user.getFirstName() + user.getLastName() +".pdf";
                }

                String body = "<html><body><div><h2>Hi " + user.getFirstName() + " " + user.getLastName() +  ",</h2><p>Thank you for registering to Dynamics POC Recruitments Drive 2022. Please have your registration details attached with this mail.<br><br>If you have any queries reply to this mail.</p><h3>With regards,<br><img src ='cid:id1'><br>Dynamics Project Oriented Community</h3></div></body></html>";

                FileSystemResource fileSystemResource = new FileSystemResource(new File(fileName));
                FileSystemResource image = new FileSystemResource(new File("F:\\REST_Frameworks\\DynamicsWebsiteOfficial\\src\\main\\resources\\logo1.png"));
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.addAttachment(user.getUsn() + "_" + user.getFirstName() + user.getLastName() +".pdf", fileSystemResource);
                helper.setText(body, true);
                helper.addInline("id1", image);
            }
        };

        try {
            mailSender.send(preparator);
            System.out.println("Sent Mails");
        } catch (MailException e) {
            System.err.println(e.getMessage());
        }
    }
}
