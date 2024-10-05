package com.emailService.emailServiceSpring.controller;

import com.emailService.emailServiceSpring.entity.EmailUsingTemplate;
import com.emailService.emailServiceSpring.entity.Template;
import com.emailService.emailServiceSpring.service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/email-template")
public class EmailTemplateController {

    @Autowired
    private EmailTemplateService emailTemplateService;

    @GetMapping
    public ResponseEntity<?> ok(){
        return new ResponseEntity<>("all OK", HttpStatus.OK);
    }

    @PostMapping("/send")
    public ResponseEntity<?> EmailSender(@RequestBody EmailUsingTemplate email) {

        String sender = email.getSender();
        String recipient = email.getRecipient();
        String templateName = email.getTemplate();

        try{
            emailTemplateService.send(sender, recipient, templateName);
            return new ResponseEntity<>("Email sent to "+recipient, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Email not sent: " + e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewTemplate(@RequestBody Template template){

        String templateName = template.getTemplateName();
        String subject = template.getSubject();
        String textBody = template.getTextBody();
        String htmlBody = template.getHtmlBody();

        try {
            emailTemplateService.createTemplate(templateName, subject, textBody, htmlBody);
            return new ResponseEntity<>("Template Created ", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error in creating Template: " + e.getMessage() , HttpStatus.EXPECTATION_FAILED);
        }
    }

}

