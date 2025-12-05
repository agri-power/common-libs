package com.agropower.common.outbox;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Outbox table for implementing the Transactional Outbox Pattern
 * Ensures reliable event publishing without dual-write problems
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "outbox_events", indexes = {
    @Index(name = "idx_processed", columnList = "processed"),
    @Index(name = "idx_created_at", columnList = "created_at")
})
public class OutboxEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "aggregate_id", nullable = false)
    private String aggregateId; // Order ID, Payment ID, etc.
    
    @Column(name = "aggregate_type", nullable = false)
    private String aggregateType; // Order, Payment, etc.
    
    @Column(name = "event_type", nullable = false)
    private String eventType; // ORDER_CREATED, PAYMENT_PROCESSED, etc.
    
    @Column(name = "payload", columnDefinition = "TEXT", nullable = false)
    private String payload; // JSON representation of the event
    
    @Column(name = "processed", nullable = false)
    private Boolean processed = false;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "processed_at")
    private LocalDateTime processedAt;
    
    @Column(name = "retry_count")
    private Integer retryCount = 0;
    
    @Column(name = "error_message", length = 1000)
    private String errorMessage;
    
    @Column(name = "correlation_id")
    private String correlationId;
    
    public OutboxEvent(String aggregateId, String aggregateType, String eventType, 
                      String payload, String correlationId) {
        this.aggregateId = aggregateId;
        this.aggregateType = aggregateType;
        this.eventType = eventType;
        this.payload = payload;
        this.correlationId = correlationId;
        this.processed = false;
        this.createdAt = LocalDateTime.now();
        this.retryCount = 0;
    }
}
