package com.emailService.emailServiceSpring.controller;

import com.emailService.emailServiceSpring.entity.EmailUsingTemplate;
import com.emailService.emailServiceSpring.entity.EmailTemplate;
import com.emailService.emailServiceSpring.service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.sesv2.model.Template;


@RestController
@RequestMapping("/email-template")
public class EmailTemplateController {

    @Autowired
    private EmailTemplateService emailTemplateService;

    @PostMapping("/send")
    public ResponseEntity<?> EmailSender(@RequestBody EmailUsingTemplate email) {

        String sender = email.getSender();
        String recipient = email.getRecipient();
        String templateName = email.getTemplate();

        //Variables as per the SAMPLE TEMPLATE given in EmailTemplate Class
        String name = "divyanshu-mahto";
        String event_name = "Big Event";
        String organiser = "Big Organizer";
        String date = "2024-10-10";
        String time = "12:00";
        String venue = "Somewhere nice";
        String poster_url = "";

        Template myTemplate = Template.builder()
                .templateName(templateName)
                .templateData("{\n" +
                        "  \"name\": \"" + name + "\",\n" +
                        "  \"event_name\": \""+ event_name +"\",\n" +
                        "  \"organiser\": \""+ organiser +"\",\n" +
                        "  \"start_date\": \""+ date +"\",\n" +
                        "  \"start_time\": \""+ time +"\",\n" +
                        "  \"venue\": \""+ venue +"\",\n" +
                        "  \"poster_url\": \""+ poster_url +"\"\n" +
                        "}")
                .build();

        try{
            emailTemplateService.send(sender, recipient, templateName, myTemplate);
            return new ResponseEntity<>("Email sent to "+recipient, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error in sending email: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewTemplate(@RequestBody EmailTemplate emailTemplate){

        String templateName = emailTemplate.getTemplateName();
        String subject = emailTemplate.getSubject();
        String textBody = emailTemplate.getTextBody();
        String htmlBody = emailTemplate.getHtmlBody();

        try {
            emailTemplateService.createTemplate(templateName, subject, textBody, htmlBody);
            return new ResponseEntity<>("Template Created ", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error in creating Template: " + e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

