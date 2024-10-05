package com.emailService.emailServiceSpring.entity;

import lombok.Data;

@Data
public class Email {

    private String sender;
    private String recipient;
    private String subject;
}
