package com.agropower.common.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Event published when a new order is created
 * Triggers the Saga workflow for order processing
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderCreatedEvent extends BaseEvent {
    
    private Long orderId;
    private Long userId;
    private String userEmail;
    private BigDecimal totalAmount;
    private List<OrderItemDto> items;
    private String paymentMethod; // COD or PREPAID
    private ShippingAddress shippingAddress;
    
    public OrderCreatedEvent(String correlationId, String source, Long orderId, 
                            Long userId, String userEmail, BigDecimal totalAmount, 
                            List<OrderItemDto> items, String paymentMethod,
                            ShippingAddress shippingAddress) {
        super("ORDER_CREATED", correlationId, source);
        this.orderId = orderId;
        this.userId = userId;
        this.userEmail = userEmail;
        this.totalAmount = totalAmount;
        this.items = items;
        this.paymentMethod = paymentMethod;
        this.shippingAddress = shippingAddress;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderItemDto {
        private Long productId;
        private String productName;
        private Integer quantity;
        private BigDecimal price;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShippingAddress {
        private String address1;
        private String address2;
        private String city;
        private String state;
        private String country;
        private String postalCode;
    }
}
