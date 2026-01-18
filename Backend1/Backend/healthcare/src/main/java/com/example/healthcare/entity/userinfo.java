package com.example.healthcare.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
// import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;

@Entity
public class userinfo {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false, unique = true)
        private String email;
        
        @Column(nullable = false)
        private String phoneNumber;

        @Column(nullable = false)
        private LocalDate dateOfBirth;

        @ManyToOne(optional = false,fetch = FetchType.EAGER)
        @JoinColumn(name = "providerId")
        private providerinfo provider;

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

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPhoneNumber() {
            return phoneNumber;
        }
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }
        public void setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
        public providerinfo getProvider() {
            return provider;
        }
        public void setProvider(providerinfo provider) {
            this.provider = provider;

        }

}
