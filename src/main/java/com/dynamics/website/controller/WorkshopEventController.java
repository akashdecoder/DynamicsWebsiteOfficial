package com.dynamics.website.controller;

import com.dynamics.website.model.WorkshopUser;
import com.dynamics.website.repository.WorkshopRepository;
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
public class WorkshopEventController {
    private final WorkshopRepository workshopRepository;

    @Autowired
    public WorkshopEventController(WorkshopRepository workshopRepository) {
        this.workshopRepository = workshopRepository;
    }

    @GetMapping("workshop")
    public String formPage(WorkshopUser workshopUser) {
        return "workshop.html";
    }

    @PostMapping("addWorkshops")
    public String addWorkshopUser(@Valid WorkshopUser workshopUser, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "/dynamics/events";
        }
        workshopRepository.save(workshopUser);
        return "redirect:workshop";
    }
}
