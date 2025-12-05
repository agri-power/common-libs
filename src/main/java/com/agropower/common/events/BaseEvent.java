package com.agropower.common.events;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base event class for all domain events in the system
 * Provides common fields and behavior for event-driven communication
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEvent {
    
    private String eventId = UUID.randomUUID().toString();
    
    private String eventType;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();
    
    private String correlationId; // For distributed tracing
    
    private String source; // Source service that generated the event
    
    private Integer version = 1; // Event version for schema evolution
    
    public BaseEvent(String eventType, String correlationId, String source) {
        this.eventType = eventType;
        this.correlationId = correlationId;
        this.source = source;
        this.timestamp = LocalDateTime.now();
        this.eventId = UUID.randomUUID().toString();
    }
}
