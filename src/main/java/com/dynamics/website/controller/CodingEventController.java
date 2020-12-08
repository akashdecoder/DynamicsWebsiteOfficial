package com.dynamics.website.controller;

import com.dynamics.website.model.CodingUser;
import com.dynamics.website.repository.CodingRepository;
import com.dynamics.website.repository.RoboticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return "redirect:coding";
    }
}
