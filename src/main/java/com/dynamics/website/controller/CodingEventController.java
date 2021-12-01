package com.dynamics.website.controller;

import com.dynamics.website.model.AppUser;
import com.dynamics.website.model.CodingUser;
import com.dynamics.website.service.UserServiceFirebase;
import com.dynamics.website.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

@Controller
public class CodingEventController {

    @Autowired
    private UserServiceFirebase userServiceFirebase;

    @GetMapping("/")
    public String codePage(CodingUser codingUser)
    {
        return "codingevent.html";
    }

    @GetMapping("/codearena")
    public String formPage(CodingUser codingUser)
    {
        return "codingevent.html";
    }

//    @PostMapping("addCoding")
//    public String addUser(@Valid CodingUser codingUser, BindingResult result, Model model, RedirectAttributes redirectAttributes) throws InterruptedException, ExecutionException {
//        if(result.hasErrors()) {
//            return "/dynamics/events";
//        }
//        if(codingUserRepository.findByEmail(codingUser.getEmail()) != null) {
//            redirectAttributes.addFlashAttribute("warning", "Email Already exists");
//            return "redirect:/dynamics/events/coding";
//        }
//        if(codingUserRepository.findByFirstName(codingUser.getFirstName()) != null) {
//            redirectAttributes.addFlashAttribute("warning", "Name Already exists");
//            return "redirect:/dynamics/events/coding";
//        }
//        if(codingUserRepository.findByUsn(codingUser.getUsn()) != null) {
//            redirectAttributes.addFlashAttribute("warning", "Usn Already exists");
//            return "redirect:/dynamics/events/coding";
//        }
//        if(codingUserRepository.findByHackid(codingUser.getHackid()) != null) {
//            redirectAttributes.addFlashAttribute("warning", "HackerRank Id Already exists. Please Use different Id");
//            return "redirect:/dynamics/events/coding";
//        }
//        codingUser.setBranch(UserUtils.getBranchName(codingUser.getUsn().substring(5, 7).toUpperCase()));
//        codingUserRepository.save(codingUser);
//        return "registrationmessage";
//    }

    @PostMapping("/codearena/addCoding")
    public String addUser(@Valid CodingUser codingUser, BindingResult result, Model model, RedirectAttributes redirectAttributes) throws InterruptedException, ExecutionException
    {

        codingUser.setBranch(UserUtils.getBranchName(codingUser.getUsn().substring(5, 7).toUpperCase()));
        Random random = new Random();
        long rand = random.nextInt(100000000);

        codingUser.setCoding_id(Long.toString(rand));

        userServiceFirebase.saveUser(codingUser);

        return "registrationmessage";
    }

    @GetMapping("/codearena/code_arena_lists")
    public String getCandidatesLists(Model model) {

        List<CodingUser> candidates = userServiceFirebase.getAllUsers();
        model.addAttribute("candidates", candidates);

        return "candidates_lists";
    }
}
