package com.example.healthcare.DTO;

import java.util.UUID;

public class UserResponseDTO {
        private UUID id;
        private String name;
        private UserGoalsResponseDTO goals;
        private RemaindersDTO remainders;
        private String tip;

        public UUID getId() {
            return id;
        }
        public void setId(UUID id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public UserGoalsResponseDTO getGoals() {
            return goals;
        }
        public void setGoals(UserGoalsResponseDTO goals) {
            this.goals = goals;
        }
        public RemaindersDTO getRemainders() {
            return remainders;
        }
        public void setRemainders(RemaindersDTO remainders) {
            this.remainders = remainders;
        }
        public String getTip() {
            return tip;
        }
        public void setTip(String tip) {
            this.tip = tip;
        }

}
