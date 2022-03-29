package com.dynamics.website.controller;

import com.dynamics.website.model.User;
import com.dynamics.website.service.*;
import com.dynamics.website.utils.UserUtils;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

@Controller
public class RecruitmentController {

    @Autowired
    private UserServiceFirebase userServiceFirebase;

    @Autowired
    private FileService fileService;

    @Autowired
    private PDFGeneratorService pdfGeneratorService;

    @Autowired
    private MailService mailService;

    @Autowired
    private ExcelSheetGenerator excelSheetGenerator;

    private StorageOptions storageOptions;

    @RequestMapping(value = "/recruitment", method = RequestMethod.GET)
    public String recruitmentPage(User user, Model model)
    {
        model.addAttribute("user", user);
        return "recruitment.html";
    }

//    @RequestParam("File")MultipartFile multipartFile

    @RequestMapping(value = "recruitment/registered", method = RequestMethod.POST)
    public String addUser(@Valid User user, @ModelAttribute User u, @RequestParam("File") MultipartFile multipartFile, BindingResult result, Model model, RedirectAttributes redirectAttributes) throws InterruptedException, ExecutionException, IOException {

        String fileUrl = "";
        Random random = new Random();
        long rand = random.nextInt(100000000);

        User user1 = userServiceFirebase.getUser(user.getUsn().toUpperCase());

        long size = multipartFile.getSize();
        double sizeMB = size * 0.00000095367432;

        if(sizeMB > 1.00) {
            System.out.println("Size of the file: " + sizeMB + "MB");
            redirectAttributes.addFlashAttribute("warning", "File Size Exceeded (Max File Size: 1MB)");
            return "redirect:/recruitment";
        }

        if(user1 != null) {
            redirectAttributes.addFlashAttribute("warning", "Already Registered. Contact event organizer for updates.");
            return "redirect:/recruitment";
        }

        user.setUser_id(Long.toString(rand));
//        user.setSentMail(Boolean.toString(Boolean.FALSE));
        user.setUsn(user.getUsn().toUpperCase());
        user.setBranch(UserUtils.getBranchName(user.getUsn().substring(5,7).toUpperCase()));

        if(user.getYear().equals("2nd Year")) {
            fileUrl = fileService.upload(multipartFile, user);
            user.setFileUrl(fileUrl);
        }

        userServiceFirebase.saveUser(user);

        model.addAttribute("user", u);

        return "registrationmessage";

    }

    @RequestMapping(value = "/generatePDF", method = RequestMethod.GET)
    public String generatePDF() throws Exception {

        List<User> users = userServiceFirebase.getAllUsers();

        for(User user: users) {
            String html = pdfGeneratorService.parseThymeleafTemplate(user);
            pdfGeneratorService.generatePDFFromHTML(user, html);
        }

        return "redirect:/recruitment";
    }


    @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public String sendMail() throws ExecutionException, InterruptedException {
        List<User> users = userServiceFirebase.getAllUsers();

        for(User user : users) {
//            if(user.getSentMail().equals(Boolean.toString(Boolean.FALSE))) {
//                mailService.sendMail(user);
//                user.setSentMail(Boolean.toString(Boolean.TRUE));
//                userServiceFirebase.updateUser(user);
//                System.out.println("Sent Mail To: " + user.getFirstName());
//            }

            mailService.sendEmailWithAttachment(user);
        }

        return "redirect:/recruitment";
    }

    @RequestMapping(value = "/generateSheet", method = RequestMethod.GET)
    public String generateSheet() throws IOException {
        List<User> users = userServiceFirebase.getAllUsers();

        excelSheetGenerator.generateRecruitmentSheet(users);

        System.out.println("Generate Sheet");

        return "redirect:/recruitment";
    }
}


