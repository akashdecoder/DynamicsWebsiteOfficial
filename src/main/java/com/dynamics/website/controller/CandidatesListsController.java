package com.dynamics.website.controller;

import com.dynamics.website.model.AppUser;
import com.dynamics.website.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CandidatesListsController {

    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/recruitments_lists")
    public String getCandidatesLists(Model model) {

        List<AppUser> candidates = appUserRepository.findAll();
        model.addAttribute("candidates", candidates);

        return "candidates_lists";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
        AppUser user= appUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid"));
        appUserRepository.delete(user);
        redirectAttributes.addFlashAttribute("message", "Deleted Candidate: "  + user.getFirstName() + " " + user.getLastName());
        return "redirect:/recruitments_lists";
    }

}
