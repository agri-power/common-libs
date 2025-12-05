package com.agropower.common.constants;

/**
 * Kafka topic names for event-driven communication
 */
public class KafkaTopics {
    
    // Order related topics
    public static final String ORDER_CREATED = "order-created";
    public static final String ORDER_COMPLETED = "order-completed";
    public static final String ORDER_CANCELLED = "order-cancelled";
    public static final String ORDER_FAILED = "order-failed";
    
    // Payment related topics
    public static final String PAYMENT_PROCESSED = "payment-processed";
    public static final String PAYMENT_FAILED = "payment-failed";
    public static final String PAYMENT_REFUND_REQUESTED = "payment-refund-requested";
    public static final String PAYMENT_REFUNDED = "payment-refunded";
    
    // Inventory related topics
    public static final String INVENTORY_RESERVED = "inventory-reserved";
    public static final String INVENTORY_RELEASED = "inventory-released";
    public static final String INVENTORY_UPDATED = "inventory-updated";
    
    // Notification related topics
    public static final String NOTIFICATION_REQUESTED = "notification-requested";
    public static final String NOTIFICATION_SENT = "notification-sent";
    public static final String NOTIFICATION_FAILED = "notification-failed";
    
    // Cart related topics
    public static final String CART_CLEARED = "cart-cleared";
    
    // Promo related topics
    public static final String PROMO_CREATED = "promo-created";
    public static final String PROMO_UPDATED = "promo-updated";
    public static final String PROMO_ACTIVATED = "promo-activated";
    public static final String PROMO_DEACTIVATED = "promo-deactivated";
    public static final String PROMO_DELETED = "promo-deleted";
    public static final String PROMO_RESERVED = "promo-reserved";
    public static final String PROMO_CONSUMED = "promo-consumed";
    public static final String PROMO_ROLLEDBACK = "promo-rolledback";
    public static final String PROMO_RESERVATION_EXPIRED = "promo-reservation-expired";
    public static final String PROMO_EVENTS = "promo-events"; // Generic promo events topic
    
    // User related topics
    public static final String USER_REGISTERED = "user-registered";
    public static final String USER_UPDATED = "user-updated";
    public static final String PASSWORD_RESET_REQUESTED = "password-reset-requested";
    public static final String OTP_NOTIFICATIONS = "otp-notifications";
    
    // Shipway related topics
    public static final String SHIPWAY_ORDER_PUSH = "shipway-order-push";
    public static final String SHIPWAY_ORDER_PUSH_DLQ = "shipway-order-push-dlq";
    public static final String SHIPWAY_TRACKING_UPDATE = "shipway-tracking-update";
    
    private KafkaTopics() {
        // Private constructor to prevent instantiation
    }
}
