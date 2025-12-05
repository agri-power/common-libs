package com.agropower.common.events;

import java.time.LocalDateTime;

/**
 * Event published when a new user registers in the system.
 * Used by notification service to send welcome email and SMS.
 */
public class UserRegisteredEvent extends BaseEvent {
    
    private Long userId;
    private String email;
    private String mobile;
    private String firstName;
    private String lastName;
    private LocalDateTime registeredAt;
    
    // Default constructor for JSON deserialization
    public UserRegisteredEvent() {
        super("UserRegistered", null, "user-management-service");
    }
    
    public UserRegisteredEvent(Long userId, String email, String mobile, 
                              String firstName, String lastName) {
        super("UserRegistered", null, "user-management-service");
        this.userId = userId;
        this.email = email;
        this.mobile = mobile;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registeredAt = LocalDateTime.now();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    @Override
    public String toString() {
        return "UserRegisteredEvent{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registeredAt=" + registeredAt +
                '}';
    }
}
