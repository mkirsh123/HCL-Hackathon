package com.example.healthcare.entity;

import java.util.UUID;

import jakarta.persistence.Column;
// import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class tipofday {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(nullable = false)
        private UUID id;

        @Column(nullable = false)
        private String tipContent;

        public UUID getId() {
                return id;
        }
        public void setId(UUID id) {
                this.id = id;
        }
        public String getTipContent() {
                return tipContent;
        }
        public void setTipContent(String tipContent) {
                this.tipContent = tipContent;
        }
}
