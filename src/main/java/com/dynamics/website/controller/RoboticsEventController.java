//package com.dynamics.website.controller;
//
//
//import com.dynamics.website.model.RoboticsUser;
//import com.dynamics.website.repository.RoboticsUserRepository;
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
//public class RoboticsEventController {
//
//    @Autowired
//    private RoboticsUserRepository roboticsUserRepository;
//
//    @GetMapping("robotics")
//    public String formPage(RoboticsUser roboticsUser) {
//        return "robotics.html";
//    }
//
//    @PostMapping("addRobotics")
//    public String addRoboticsUser(@Valid RoboticsUser roboticsUser, BindingResult result, Model model,
//                                  RedirectAttributes redirectAttributes) throws InterruptedException, ExecutionException {
//        if(result.hasErrors()) {
//            return "/dynamics/events";
//        }
//
//        RoboticsUser user = roboticsUserRepository.findByEmail(roboticsUser.getEmail());
//        if(user != null) {
//            redirectAttributes.addFlashAttribute("warning", "User Already Registered");
//            return "redirect:/dynamics/events/robotics";
//        }
//        roboticsUser.setBranch(UserUtils.getBranchName(roboticsUser.getUsn().substring(5, 7).toUpperCase()));
//
//        roboticsUserRepository.save(roboticsUser);
//
//        return "registrationmessage";
//    }
//}
