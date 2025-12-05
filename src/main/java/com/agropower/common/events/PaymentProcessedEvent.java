package com.agropower.common.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Event published when payment is successfully processed
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PaymentProcessedEvent extends BaseEvent {
    
    private Long orderId;
    private Long paymentId;
    private String transactionId;
    private BigDecimal amount;
    private String paymentMethod;
    private String paymentStatus; // PAID, PENDING
    
    public PaymentProcessedEvent(String correlationId, String source, 
                                Long orderId, Long paymentId, String transactionId,
                                BigDecimal amount, String paymentMethod, String paymentStatus) {
        super("PAYMENT_PROCESSED", correlationId, source);
        this.orderId = orderId;
        this.paymentId = paymentId;
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }
}
