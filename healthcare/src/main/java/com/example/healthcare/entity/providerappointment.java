package com.example.healthcare.entity;

import java.time.LocalDate;
import java.util.UUID;

// import jakarta.annotation.Generated;

// import org.springframework.cglib.core.Local;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class providerappointment {

        @Id
        @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
        private UUID id;

        @ManyToOne(optional = false)
        @JoinColumn(name = "provider_id")
        private providerinfo provider;

        @ManyToOne(optional = false)
        @JoinColumn(name = "user_id")
        private userinfo user;

        @Column(nullable = false)
        private LocalDate providerappointmentdate;

        public providerinfo getProvider() {
                return provider;
        }
        public void setProvider(providerinfo provider) {
                this.provider = provider;
        }
        public userinfo getUser() {
                return user;
        }
        public void setUser(userinfo user) {
                this.user = user;
        }
        public LocalDate getProviderappointmentdate() {
                return providerappointmentdate;
        }
        public void setProviderappointmentdate(LocalDate providerappointmentdate) {
                this.providerappointmentdate = providerappointmentdate;
        }
}