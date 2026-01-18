package com.example.healthcare.DTO;

import java.time.LocalDate;
import java.util.UUID;

public class appointmentdto {
    private UUID userId;
    private UUID providerId;
    private LocalDate time;
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public UUID getProviderId() {
        return providerId;
    }
    public void setProviderId(UUID providerId) {
        this.providerId = providerId;
    }
    public LocalDate getTime() {
        return time;
    }
    public void setTime(LocalDate time) {
        this.time = time;
    }
}
