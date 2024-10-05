package com.emailService.emailServiceSpring.entity;
import lombok.Data;

@Data
public class EmailUsingTemplate {

    private String sender;
    private String recipient;
    private String template;
}
