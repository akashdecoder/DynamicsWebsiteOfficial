package com.dynamics.website.controller;

import com.dynamics.website.model.CodingUser;
import com.dynamics.website.model.FileUser;
import com.dynamics.website.service.ExcelSheetGenerator;
import com.dynamics.website.service.FileService;
import com.dynamics.website.service.MailService;
import com.dynamics.website.service.UserServiceFirebase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

@Controller
public class CodingEventController {

//    private StorageOptions storageOptions;

    @Autowired
    private UserServiceFirebase userServiceFirebase;

    @Autowired
    private MailService mailService;

    @Autowired
    private ExcelSheetGenerator excelSheetGenerator;

    @Autowired
    private FileService fileService;

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

    @PostMapping("/codearena/addCoding")
    public String addUser(@Valid CodingUser codingUser, BindingResult result, Model model, RedirectAttributes redirectAttributes) throws InterruptedException, ExecutionException, IOException {
        Random random = new Random();
        long rand = random.nextInt(100000000);

        CodingUser user = userServiceFirebase.getUser(codingUser.getUsn());

        if(user != null) {
            if(user.getSentMail().equals(Boolean.toString(Boolean.TRUE)) == true) {
                redirectAttributes.addFlashAttribute("warning", "Already Registered. Contact event organizer for updates.");
                return "redirect:/";
            }
        }

        Date date = new Date();
        codingUser.setCoding_id(Long.toString(rand));
        codingUser.setDate(date.toString());
        codingUser.setSentMail(Boolean.toString(Boolean.FALSE));
//        FileUser fileUser = new FileUser();
//        fileUser.setMultipartFile(multipartFile);
//        fileService.upload(multipartFile, codingUser);

//        Storage storage = storageOptions.getService();
//
//        Blob blob = storage.get(BlobId.of("dynamicspoc-95ae9.appspot.com", codingUser.getUsn()));
//        ReadChannel readChannel = blob.reader();
//        InputStream inputStream = Channels.newInputStream(readChannel);
//        byte[] content = null;
//        content = IOUtils.toByteArray(inputStream);
//        final ByteArrayResource byteArrayResource = new ByteArrayResource(content);
//
//        codingUser.setFileUrl(byteArrayResource);
//        System.out.println(byteArrayResource.toString());

        userServiceFirebase.saveUser(codingUser);

        return "registrationmessage";
    }

    @GetMapping("/codearena/code_arena_lists")
    public String getCandidatesLists(Model model) {

        List<CodingUser> candidates = userServiceFirebase.getAllUsers();
        model.addAttribute("count", candidates.size());
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
