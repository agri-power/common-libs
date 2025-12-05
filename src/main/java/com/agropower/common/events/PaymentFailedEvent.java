package com.agropower.common.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Event published when payment processing fails
 * Triggers compensation logic in Saga workflow
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PaymentFailedEvent extends BaseEvent {
    
    private Long orderId;
    private String reason;
    private String errorCode;
    
    public PaymentFailedEvent(String correlationId, String source, 
                             Long orderId, String reason, String errorCode) {
        super("PAYMENT_FAILED", correlationId, source);
        this.orderId = orderId;
        this.reason = reason;
        this.errorCode = errorCode;
    }
}
