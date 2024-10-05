package com.emailService.emailServiceSpring.controller;


import com.emailService.emailServiceSpring.entity.Email;
import com.emailService.emailServiceSpring.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<?> EmailSender(@RequestBody Email email) {

        String sender = email.getSender();
        String recipient = email.getRecipient();
        String subject = email.getSubject();

        String bodyHTML = "<html>" + "<head></head>" + "<body>" + "<h1>Hello!</h1>"
                + "<p> Mail sent using AWS SES.</p>" + "</body>" + "</html>";

        try{
            emailService.send(sender, recipient, subject, bodyHTML);
            return new ResponseEntity<>("Email sent to "+recipient, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Email not sent: " + e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }

    }

}
