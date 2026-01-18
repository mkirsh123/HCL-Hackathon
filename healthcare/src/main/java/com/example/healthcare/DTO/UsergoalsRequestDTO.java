package com.example.healthcare.DTO;

public class UsergoalsRequestDTO {

    private int steps;
    private int activeTimeInMinutes;
    private int sleeptime;

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getActiveTimeInMinutes() {
        return activeTimeInMinutes;
    }

    public void setActiveTimeInMinutes(int activeTimeInMinutes) {
        this.activeTimeInMinutes = activeTimeInMinutes;
    }

    public int getSleeptime() {
        return sleeptime;
    }

    public void setSleeptime(int sleeptime) {
        this.sleeptime = sleeptime;
    }
}
