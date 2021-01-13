package com.dynamics.website.controller;

import com.dynamics.website.model.AppUser;
import com.dynamics.website.service.UserService;
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
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/dynamics/")
public class RegisterController {
    @Autowired
    UserService userService;

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("recruitment")
    public String formPage(AppUser appUser) {
        return "recruitment.html";
    }

    @PostMapping("add")
    public String addUser(@Valid AppUser appUser, BindingResult result, Model model) throws InterruptedException,
            ExecutionException {
        if(result.hasErrors()) {
            return "/dynamics";
        }
        userService.saveUser(appUser);
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("dynamicsPOC19.sit@gmail.com");
        mailMessage.setTo(appUser.getEmail());

        String mailSubject = "Dynamics Recruitments";
        String mailContent = "Thank You " + appUser.getFirstName() + " for coming forward" +
                " to Dynamics recruitments\n";
        mailContent = mailContent + "\n\nWith Regards,\nDynamics\n(Project Oriented Community)";

        mailMessage.setSubject(mailSubject);
        mailMessage.setText(mailContent);

        mailSender.send(mailMessage);
        return "registrationmessage.html";
    }
}
