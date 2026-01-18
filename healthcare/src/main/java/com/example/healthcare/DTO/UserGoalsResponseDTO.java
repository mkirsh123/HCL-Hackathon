package com.example.healthcare.DTO;

public class UserGoalsResponseDTO {
        private int steps;
        private int ActiveTimeInMinutes;
        private int sleeptime;

        public int getSteps(){
            return steps;
        }
        public int getActiveTimeInMinutes(){
                return ActiveTimeInMinutes;
        }
        public int getSleeptime(){
                return sleeptime;
        }
        public void setSteps(int steps){
                this.steps=steps;
        }
        public void setSleeptime(int sleeptime){
                this.sleeptime=sleeptime;
        }
        public void setActiveTimeInMinutes(int ActiveTimeInMinutes){
                this.ActiveTimeInMinutes=ActiveTimeInMinutes;
        } 
}
