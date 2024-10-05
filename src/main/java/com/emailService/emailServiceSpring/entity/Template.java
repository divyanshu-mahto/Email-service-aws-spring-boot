package com.emailService.emailServiceSpring.entity;

import lombok.Data;

@Data
public class Template {
    private String templateName;
    private String subject;
    private String textBody;
    private String htmlBody;
}

/*
{
    "Template": {
        "TemplateName": "EventRegistrationTemplate",
        "SubjectPart": "You're Successfully Registered for {{event_name}}!",
        "TextPart": "Hi {{name}},\r\nWe are excited to inform you that your registration for {{event_name}} has been confirmed!\r\n\n{{event_name}}\r\n\nOrganized by: {{organiser}}\r\nDescription: {{description}}\r\nStart Date: {{start_date}} at {{start_time}}\r\nEnd Date: {{end_date}} at {{end_time}}\r\nVenue: {{venue}}\r\n\nThank you for registering, and we look forward to seeing you at the event!",
        "HtmlPart": "<div style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 20px;'> <div style='max-width: 600px; margin: auto; background-color: white; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);'> <h1 style='color: #2c3e50;'>Hi {{name}},</h1> <p style='font-size: 16px; color: #34495e;'>We are excited to inform you that your registration for <strong>{{event_name}}</strong> has been confirmed! Below are the event details:</p> <div style='background-color: #ecf0f1; padding: 15px; border-radius: 8px;'> <h2 style='color: #2980b9;'>{{event_name}}</h2> <p><strong>Organized by</strong>: {{organiser}}</p> <p><strong>Description</strong>: {{description}}</p> <p><strong>Start Date</strong>: {{start_date}} at {{start_time}}</p> <p><strong>End Date</strong>: {{end_date}} at {{end_time}}</p> <p><strong>Venue</strong>: {{venue}}</p> </div> <p style='font-size: 16px; color: #34495e;'>Thank you for registering, and we look forward to seeing you at the event!</p> <p style='text-align: center; color: #95a5a6; font-size: 14px;'>The {{organiser}} Team</p> </div> </div>"
    }
}
 */
