package com.dynamics.website.controller;

import com.dynamics.website.model.CodingUser;
import com.dynamics.website.repository.CodingUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/dynamics/events/")
public class CodingEventController {

    @Autowired
    private CodingUserRepository codingUserRepository;

    @GetMapping("coding")
    public String formPage(CodingUser codingUser) {
        return "codingevent.html";
    }

    @PostMapping("addCoding")
    public String addUser(@Valid CodingUser codingUser, BindingResult result, Model model, RedirectAttributes redirectAttributes) throws InterruptedException, ExecutionException {
        if(result.hasErrors()) {
            return "/dynamics/events";
        }
        if(codingUserRepository.findByEmail(codingUser.getEmail()) != null) {
            redirectAttributes.addFlashAttribute("warning", "Email Already exists");
            return "redirect:/dynamics/events/coding";
        }
        if(codingUserRepository.findByFirstName(codingUser.getFirstName()) != null) {
            redirectAttributes.addFlashAttribute("warning", "Name Already exists");
            return "redirect:/dynamics/events/coding";
        }
        if(codingUserRepository.findByUsn(codingUser.getUsn()) != null) {
            redirectAttributes.addFlashAttribute("warning", "Usn Already exists");
            return "redirect:/dynamics/events/coding";
        }
        if(codingUserRepository.findByHackid(codingUser.getHackid()) != null) {
            redirectAttributes.addFlashAttribute("warning", "HackerRank Id Already exists. Please Use different Id");
            return "redirect:/dynamics/events/coding";
        }
        codingUserRepository.save(codingUser);
        return "registrationmessage";
    }
}
