package com.example.healthcare.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

// package com.example.healthcare.entity;

import jakarta.persistence.*;

@Entity
public class usergoals {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private userinfo user;

    @Column(nullable = false)
    private int dailyStepGoal;

    @Column(nullable = false)
    private int activeTimeGoal;

    @Column(nullable = false)
    private int sleeptime;

    // ===== getters & setters =====

    public UUID getId() {
        return id;
    }

    public userinfo getUser() {
        return user;
    }

    public void setUser(userinfo user) {
        this.user = user;
    }

    public int getDailyStepGoal() {
        return dailyStepGoal;
    }

    public void setDailyStepGoal(int dailyStepGoal) {
        this.dailyStepGoal = dailyStepGoal;
    }

    public int getActiveTimeGoal() {
        return activeTimeGoal;
    }

    public void setActiveTimeGoal(int activeTimeGoal) {
        this.activeTimeGoal = activeTimeGoal;
    }

    public int getSleeptime() {
        return sleeptime;
    }

    public void setSleeptime(int sleeptime) {
        this.sleeptime = sleeptime;
    }
}
