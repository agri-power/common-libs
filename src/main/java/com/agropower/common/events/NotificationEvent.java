package com.agropower.common.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Event published to send notifications (email, SMS, etc.)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NotificationEvent extends BaseEvent {
    
    private String recipient; // Email or phone number
    private String notificationType; // EMAIL, SMS, PUSH
    private String templateName;
    private Map<String, Object> templateData;
    private String subject;
    
    public NotificationEvent(String correlationId, String source, 
                           String recipient, String notificationType, 
                           String templateName, Map<String, Object> templateData,
                           String subject) {
        super("NOTIFICATION_REQUESTED", correlationId, source);
        this.recipient = recipient;
        this.notificationType = notificationType;
        this.templateName = templateName;
        this.templateData = templateData;
        this.subject = subject;
    }
}
