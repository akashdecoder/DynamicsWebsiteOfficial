package com.dynamics.website.controller;


import com.dynamics.website.model.RoboticsUser;
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
public class RoboticsEventController {
    private final RoboticsRepository roboticsRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    public RoboticsEventController(RoboticsRepository roboticsRepository) {
        this.roboticsRepository = roboticsRepository;
    }

    @GetMapping("robotics")
    public String formPage(RoboticsUser roboticsUser) {
        return "robotics.html";
    }

    @PostMapping("addRobotics")
    public String addRoboticsUser(@Valid RoboticsUser roboticsUser, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "/dynamics/events";
        }
        roboticsRepository.save(roboticsUser);
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("dynamicsPOC19.sit@gmail.com");
        mailMessage.setTo(roboticsUser.getEmail());

        String mailSubject = roboticsUser.getEvent_name() + " Registration.";
        String mailContent = "Thank You " + roboticsUser.getFirstName() + " for registering to " +
                roboticsUser.getEvent_name()+".\nKeep in touch to know more updates.";
        mailContent = mailContent + "\n\nWith Regards,\nDynamics\n(Project Oriented Community)";

        mailMessage.setSubject(mailSubject);
        mailMessage.setText(mailContent);

        mailSender.send(mailMessage);
        return "registrationmessage.html";
    }
}
