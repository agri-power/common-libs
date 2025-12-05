package com.agropower.common.dto;

import java.time.LocalDateTime;

/**
 * Standard API response wrapper for all microservices
 */
public class ApiResponse<T> {
    
    private boolean success;
    private String message;
    private T data;
    private LocalDateTime timestamp;
    private String correlationId;
    
    public ApiResponse() {}
    
    public ApiResponse(boolean success, String message, T data, LocalDateTime timestamp, String correlationId) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
        this.correlationId = correlationId;
    }
    
    // Getters and Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    
    public String getCorrelationId() { return correlationId; }
    public void setCorrelationId(String correlationId) { this.correlationId = correlationId; }
    
    // Factory methods
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<T>(true, message, data, LocalDateTime.now(), null);
    }
    
    public static <T> ApiResponse<T> success(T data) {
        return success(data, "Operation successful");
    }
    
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<T>(false, message, null, LocalDateTime.now(), null);
    }
    
    public static <T> ApiResponse<T> error(String message, String correlationId) {
        return new ApiResponse<T>(false, message, null, LocalDateTime.now(), correlationId);
    }
}
