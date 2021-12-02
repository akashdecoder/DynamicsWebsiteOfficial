//package com.dynamics.website.controller;
//
//import com.dynamics.website.model.WorkshopUser;
//import com.dynamics.website.repository.WorkshopUserRepository;
//import com.dynamics.website.utils.UserUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.validation.Valid;
//import java.util.concurrent.ExecutionException;
//
//@Controller
//@RequestMapping("/dynamics/events/")
//public class WorkshopEventController {
//
//    @Autowired
//    private WorkshopUserRepository workshopUserRepository;
//
//    @GetMapping("workshop")
//    public String formPage(WorkshopUser workshopUser) {
//        return "workshop.html";
//    }
//
//    @PostMapping("addWorkshops")
//    public String addWorkshopUser(@Valid WorkshopUser workshopUser, BindingResult result, Model model,
//                                  RedirectAttributes redirectAttributes) throws InterruptedException, ExecutionException {
//        if(result.hasErrors()) {
//            return "/dynamics/events";
//        }
//        WorkshopUser user = workshopUserRepository.findByEmail(workshopUser.getEmail());
//        if(user != null) {
//            redirectAttributes.addFlashAttribute("warning", "User Already Registered");
//            return "redirect:/dynamics/events/workshop";
//        }
//        workshopUser.setBranch(UserUtils.getBranchName(workshopUser.getUsn().substring(5, 7).toUpperCase()));
//        workshopUserRepository.save(workshopUser);
//        return "registrationmessage";
//    }
//}
