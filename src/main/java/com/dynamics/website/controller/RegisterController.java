package com.dynamics.website.controller;

import com.dynamics.website.model.AppUser;
import com.dynamics.website.model.FileUser;
import com.dynamics.website.repository.AppUserRepository;
import com.dynamics.website.repository.FileDbRepository;
import com.dynamics.website.service.FileService;
import com.dynamics.website.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private FileDbRepository fileDbRepository;

    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public String formPage(AppUser appUser) {
        return "recruitment.html";
    }

    @PostMapping("/registered")
    public String addUser(@Valid AppUser appUser, @RequestParam("File") MultipartFile multipartFile, BindingResult result, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "/";
        }
        AppUser user = appUserRepository.findByEmail(appUser.getEmail());

        String[] domain = appUser.getEmail().split("@", 2);
        if((domain[1].compareTo("sit.ac.in") < 0) && (domain[1].compareTo("gmail.com") < 0)) {
            redirectAttributes.addFlashAttribute("warning", "Please use college mail id");
            return "redirect:/";
        }

        if(user != null) {
            redirectAttributes.addFlashAttribute("warning", "User Already Registered");
            return "redirect:/";
        }
        FileUser file = fileService.storeFile(multipartFile);
        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(file.getId())
                .toUriString();

        appUser.setBranch(UserUtils.getBranchName(appUser.getUsn().substring(5, 7).toUpperCase()));
        appUser.setFileUrl(fileUri);
        appUserRepository.save(appUser);
        return "registrationmessage";
    }
}
