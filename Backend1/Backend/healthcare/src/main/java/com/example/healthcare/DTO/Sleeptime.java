package com.example.healthcare.DTO;

public class Sleeptime {
        private int hours;
        private int minutes;

        public int gethours(){
            return hours;
        }
        public int getminutes(){
            return minutes;
        }
        public void sethours(int hours){
            this.hours=hours;
        }
        public void setminutes(int minutes){
            this.minutes=minutes;
        }
}
