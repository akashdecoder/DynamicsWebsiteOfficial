package com.dynamics.website.controller;

import com.dynamics.website.model.CodingUser;
import com.dynamics.website.repository.CodingRepository;
import com.dynamics.website.repository.RoboticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/dynamics/events/")
public class CodingEventController {
    private final CodingRepository codingRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    public CodingEventController(CodingRepository codingRepository) {
        this.codingRepository = codingRepository;
    }

    @GetMapping("coding")
    public String formPage(CodingUser codingUser) {
        return "codingevent.html";
    }

    @PostMapping("add")
    public String addUser(@Valid CodingUser codingUser, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "/dynamics/events";
        }
        codingRepository.save(codingUser);
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("dynamicsPOC19.sit@gmail.com");
        mailMessage.setTo(codingUser.getEmail());

        String mailSubject = codingUser.getEvent_name() + " Registration.";
        String mailContent = "Thank You " + codingUser.getFirstName() + " for registering to " +
                codingUser.getEvent_name()+".\nKeep in touch to know more updates.";
        mailContent = mailContent + "\n\nWith Regards,\nDynamics\n(Project Oriented Community)";

        mailMessage.setSubject(mailSubject);
        mailMessage.setText(mailContent);

        mailSender.send(mailMessage);
        return "registrationmessage.html";
    }
}
