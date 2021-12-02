package com.dynamics.website.controller;

import com.dynamics.website.model.CodingUser;
import com.dynamics.website.service.ExcelSheetGenerator;
import com.dynamics.website.service.MailService;
import com.dynamics.website.service.UserServiceFirebase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

@Controller
public class CodingEventController {

    @Autowired
    private UserServiceFirebase userServiceFirebase;

    @Autowired
    private MailService mailService;

    @Autowired
    private ExcelSheetGenerator excelSheetGenerator;

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
        Random random = new Random();
        long rand = random.nextInt(100000000);

        Date date = new Date();
        codingUser.setCoding_id(Long.toString(rand));
        codingUser.setDate(date.toString());
        codingUser.setSentMail(Boolean.toString(Boolean.FALSE));

        userServiceFirebase.saveUser(codingUser);

        return "registrationmessage";
    }

    @GetMapping("/codearena/code_arena_lists")
    public String getCandidatesLists(Model model) {

        List<CodingUser> candidates = userServiceFirebase.getAllUsers();
        model.addAttribute("candidates", candidates);

        return "candidates_lists";
    }

    @GetMapping("/delete_user/{usn}")
    public String deleteUser(@PathVariable("usn") String usn, Model model, RedirectAttributes redirectAttributes) throws ExecutionException, InterruptedException {
        String result = userServiceFirebase.deleteUser(usn);
        redirectAttributes.addFlashAttribute("message", "Deleted Candidate: " +  usn);
        return "redirect:/codearena/code_arena_lists";
    }

    @GetMapping("/sendingMail")
    public String sendMail() throws ExecutionException, InterruptedException {
        List<CodingUser> codingUsers = userServiceFirebase.getAllUsers();

        for(CodingUser user : codingUsers) {
            if(user.getSentMail().equals(Boolean.toString(Boolean.FALSE))) {
                mailService.sendMail(user);
                user.setSentMail(Boolean.toString(Boolean.TRUE));
                userServiceFirebase.updateUser(user);
                System.out.println("Sent Mail To: " + user.getFirstName());
            }
        }

        return "redirect:/codearena/code_arena_lists";
    }

    @GetMapping("/generateSheet")
    public String generateSheet() throws IOException {
        List<CodingUser> codingUsers = userServiceFirebase.getAllUsers();

        excelSheetGenerator.generateCodingEventSheet(codingUsers);

        System.out.println("Generate Sheet");

        return "redirect:/codearena/code_arena_lists";
    }
}
