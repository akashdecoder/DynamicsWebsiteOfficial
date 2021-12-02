//package com.dynamics.website.controller;
//
//import com.dynamics.website.model.AppUser;
//import com.dynamics.website.model.FileDb;
//import com.dynamics.website.model.FileUser;
//import com.dynamics.website.model.RoboticsUser;
////import com.dynamics.website.service.FileService;
//import com.dynamics.website.repository.FileDbRepository;
//import com.dynamics.website.service.FileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//import java.io.File;
//import java.io.IOException;
//
//@Controller
//public class FileController {
//
//    @Autowired
//    FileService fileService;
//
//    @Autowired
//    private FileDbRepository fileDbRepository;
//
//    @GetMapping("/file")
//    public String formPage(FileUser fileUser) {
//        return "uploadFile.html";
//    }
//
//    @PostMapping("/uploadFiles")
//    public String upload(@Valid FileUser fileUser, @RequestParam("File") MultipartFile multipartFile,
//                         BindingResult result, HttpServletRequest request, Model model) throws IOException {
//        if(result.hasErrors()) {
//            return "/file";
//        }
//        String name = request.getParameter("name");
//        String usn = request.getParameter("usn");
//        FileUser file = fileService.storeFile(multipartFile);
//        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(file.getId())
//                .toUriString();
//
//        FileDb fileDb = new FileDb();
//        fileDb.setName(name);
//        fileDb.setUsn(usn);
//        fileDb.setFileUrl(fileUri);
//
//        fileDbRepository.save(fileDb);
//
//        model.addAttribute("message", "Uploaded");
//        return "registrationmessage";
//    }
//
//    @GetMapping("/downloadFile/{fileId}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
//        // Load file from database
//        FileUser dbFile = fileService.getFile(fileId);
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
//                .body(new ByteArrayResource(dbFile.getData()));
//    }
//}
