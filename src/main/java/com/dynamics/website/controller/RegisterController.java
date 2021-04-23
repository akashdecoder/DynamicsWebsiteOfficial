package com.dynamics.website.controller;

import com.dynamics.website.model.AppUser;
import com.dynamics.website.service.UserService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.tomcat.jni.OS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/dynamics/")
public class RegisterController {
    @Autowired
    UserService userService;

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("recruitment")
    public String formPage(AppUser appUser) {
        return "recruitment.html";
    }

    @PostMapping("add")
    public String addUser(@Valid AppUser appUser, BindingResult result, Model model) throws InterruptedException,
            ExecutionException {
        if(result.hasErrors()) {
            return "/dynamics";
        }
        userService.saveUser(appUser);

//        try {
//            generatePdf(appUser);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("dynamicsPOC19.sit@gmail.com");
        mailMessage.setTo(appUser.getEmail());

        String mailSubject = "Dynamics Recruitments";
        String mailContent = "Thank You " + appUser.getFirstName() + " for coming forward" +
                " to Dynamics recruitments\n";
        mailContent = mailContent + "\n\nWith Regards,\nDynamics\n(Project Oriented Community)";

        mailMessage.setSubject(mailSubject);
        mailMessage.setText(mailContent);


        mailSender.send(mailMessage);
        return "registrationmessage.html";
    }

//    public void generatePdf(AppUser user) throws IOException, DocumentException {
//        String OS = System.getProperty("os.name").toLowerCase();
//        String path = "";
//        if(OS.indexOf("win") >= 0) {
//            path = "F:/"+user.getFirstName()+".pdf";
//        } else if(OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") >= 0) {
//            path = "/home/" + user.getFirstName() + ".pdf";
//        }
//        Document document = new Document();
//        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
//        document.open();
//        addMetaData(document);
//        Paragraph paragraph = new Paragraph();
//        paragraph.add(new Paragraph("Registration", new Font(Font.FontFamily.TIMES_ROMAN, 18)));
//        addEmptyLine(paragraph, 1);
//        paragraph.add(new Paragraph("FirstName: " + user.getFirstName(), new Font(Font.FontFamily.TIMES_ROMAN, 12,
//                Font.BOLD)));
//        addEmptyLine(paragraph, 1);
//        paragraph.add(new Paragraph("LastName: " + user.getLastName(), new Font(Font.FontFamily.TIMES_ROMAN, 12,
//                Font.BOLD)));
//        addEmptyLine(paragraph, 1);
//        paragraph.add(new Paragraph("Email: " + user.getEmail(), new Font(Font.FontFamily.TIMES_ROMAN, 12,
//                Font.BOLD)));
//        addEmptyLine(paragraph, 1);
//        paragraph.add(new Paragraph("Branch: " + user.getBranch(), new Font(Font.FontFamily.TIMES_ROMAN, 12,
//                Font.BOLD)));
//        addEmptyLine(paragraph, 1);
//        paragraph.add(new Paragraph("USN: " + user.getUsn(), new Font(Font.FontFamily.TIMES_ROMAN, 12,
//                Font.BOLD)));
//        addEmptyLine(paragraph, 1);
//        paragraph.add(new Paragraph("Year: " + user.getYear(), new Font(Font.FontFamily.TIMES_ROMAN, 12,
//                Font.BOLD)));
//        addEmptyLine(paragraph, 1);
//        paragraph.add(new Paragraph("Contact: " + user.getContact(), new Font(Font.FontFamily.TIMES_ROMAN, 12,
//                Font.BOLD)));
//        addEmptyLine(paragraph, 1);
//        document.add(paragraph);
//        document.newPage();
//        document.close();
//    }
//
//    public void addMetaData(Document document) {
//        document.addTitle("Registration Dynamics");
//    }
//
//    private static void addEmptyLine(Paragraph paragraph, int number) {
//        for (int i = 0; i < number; i++) {
//            paragraph.add(new Paragraph(" "));
//        }
//    }
}
