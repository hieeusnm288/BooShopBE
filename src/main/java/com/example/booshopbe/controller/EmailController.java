package com.example.booshopbe.controller;

import com.example.booshopbe.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/send-email")
public class EmailController {
    @Autowired
    EmailService emailService;

    @GetMapping("/send")
    public String sendEmail() {
        emailService.sendSimpleEmail("nguyenminhhieu28801@gmail.com", "Test Email", "This is a test email.");
        return "Email sent successfully!";
    }
}
