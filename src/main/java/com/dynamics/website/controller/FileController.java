package com.dynamics.website.controller;

import com.dynamics.website.model.FileUser;
import com.dynamics.website.model.RoboticsUser;
import com.dynamics.website.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/dynamics/")
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("file")
    public String formPage(FileUser fileUser) {
        return "uploadFile.html";
    }

    @PostMapping("uploadFiles")
    public String upload(FileUser fileUser, @RequestParam("File") MultipartFile multipartFile,
                         BindingResult result, Model model) throws IOException {
        if(result.hasErrors()) {
            return "/dynamics";
        }
        System.out.println(fileUser.getName());
        System.out.println(fileUser.getFile());
        fileService.upload(multipartFile);
        return "registrationmessage.html";
    }
}
