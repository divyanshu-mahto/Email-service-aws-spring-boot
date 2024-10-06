package com.emailService.emailServiceSpring.entity;

import lombok.Data;

@Data
public class EmailTemplate {
    private String templateName;
    private String subject;
    private String textBody;
    private String htmlBody;
}

/*
SAMPLE EVENT INVITATION TEMPLATE

{
    "Template": {
        "templateName": "EventInvitationTemplate",
        "subject": "You're Invited to {{event_name}}!",
        "textBody": "Hi {{name}},\r\nYou are invited to attend {{event_name}}.\r\n\nEvent Date: {{start_date}} at {{start_time}}\r\nVenue: {{venue}}\r\n\nWe hope to see you there!",
        "htmlBody": "<div style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 20px;'> <div style='max-width: 600px; margin: auto; background-color: white; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);'> <h1 style='color: #2c3e50;'>Hi {{name}},</h1> <p style='font-size: 16px; color: #34495e;'>You are invited to attend <strong>{{event_name}}</strong>.</p> <div style='background-color: #ecf0f1; padding: 15px; border-radius: 8px;'> <p><strong>Event Date</strong>: {{start_date}} at {{start_time}}</p> <p><strong>Venue</strong>: {{venue}}</p> </div> <p style='font-size: 16px; color: #34495e;'>We hope to see you there!</p> <p style='text-align: center; color: #95a5a6; font-size: 14px;'>The {{organiser}} Team</p> </div> </div>"
    }
}
 */
