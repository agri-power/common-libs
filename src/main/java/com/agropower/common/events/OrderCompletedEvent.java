package com.agropower.common.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Event published when order is successfully completed
 * Final step in the Saga workflow
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderCompletedEvent extends BaseEvent {
    
    private Long orderId;
    private Long userId;
    private String orderStatus;
    
    public OrderCompletedEvent(String correlationId, String source, 
                              Long orderId, Long userId, String orderStatus) {
        super("ORDER_COMPLETED", correlationId, source);
        this.orderId = orderId;
        this.userId = userId;
        this.orderStatus = orderStatus;
    }
}
