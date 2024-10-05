package com.emailService.emailServiceSpring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sesv2.SesV2Client;
import software.amazon.awssdk.services.sesv2.model.*;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    private final SesV2Client sesV2Client;

    public EmailService(SesV2Client sesV2Client) {
        this.sesV2Client = sesV2Client;
    }

    public void send(String sender, String recipient, String subject, String bodyHTML) throws Exception {

        Destination destination = Destination.builder()
                .toAddresses(recipient)
                .build();

        Content subjectContent = Content.builder()
                .data(subject)
                .build();

        Content htmlContent = Content.builder()
                .data(bodyHTML)
                .build();

        Body body = Body.builder()
                .html(htmlContent)
                .build();

        Message msg = Message.builder()
                .subject(subjectContent)
                .body(body)
                .build();

        EmailContent emailContent = EmailContent.builder()
                .simple(msg)
                .build();

        SendEmailRequest emailRequest = SendEmailRequest.builder()
                .destination(destination)
                .content(emailContent)
                .fromEmailAddress(sender)
                .build();

        try {
            logger.info("Attempting to send an email through Amazon SES...");
            SendEmailResponse response = sesV2Client.sendEmail(emailRequest);
            logger.info("Email sent! Message ID: {}", response.messageId());
        } catch (SesV2Exception e) {
            logger.error("Failed to send email: {}", e.awsErrorDetails().errorMessage());
            throw new Exception("Failed to send email: " + e.awsErrorDetails().errorMessage());
        }
    }
}
