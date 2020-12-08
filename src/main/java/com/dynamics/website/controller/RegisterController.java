package com.dynamics.website.controller;

import com.dynamics.website.model.AppUser;
import com.dynamics.website.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/dynamics/")
public class RegisterController {
    private final RegisterRepository registerRepository;

    @Autowired
    public RegisterController(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @GetMapping("recruitment")
    public String formPage(AppUser appUser) {
        return "recruitment.html";
    }

    @PostMapping("add")
    public String addUser(@Valid AppUser appUser, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "/dynamics";
        }
        registerRepository.save(appUser);
        return "redirect:recruitment";
    }
}
