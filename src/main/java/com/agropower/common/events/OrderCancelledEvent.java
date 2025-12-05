package com.agropower.common.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Event published when an order is cancelled
 * Part of compensation logic in Saga pattern
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderCancelledEvent extends BaseEvent {
    
    private Long orderId;
    private String reason;
    private String cancelledBy; // System or User
    
    public OrderCancelledEvent(String correlationId, String source, 
                              Long orderId, String reason, String cancelledBy) {
        super("ORDER_CANCELLED", correlationId, source);
        this.orderId = orderId;
        this.reason = reason;
        this.cancelledBy = cancelledBy;
    }
}
