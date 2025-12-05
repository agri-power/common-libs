package com.agropower.common.util;

import org.slf4j.MDC;

import java.util.UUID;

/**
 * Utility for managing correlation IDs for distributed tracing
 */
public class CorrelationIdUtil {
    
    private static final String CORRELATION_ID_KEY = "correlationId";
    
    public static String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }
    
    public static void setCorrelationId(String correlationId) {
        MDC.put(CORRELATION_ID_KEY, correlationId);
    }
    
    public static String getCorrelationId() {
        String correlationId = MDC.get(CORRELATION_ID_KEY);
        if (correlationId == null) {
            correlationId = generateCorrelationId();
            setCorrelationId(correlationId);
        }
        return correlationId;
    }
    
    public static void clearCorrelationId() {
        MDC.remove(CORRELATION_ID_KEY);
    }
    
    private CorrelationIdUtil() {
        // Private constructor to prevent instantiation
    }
}
