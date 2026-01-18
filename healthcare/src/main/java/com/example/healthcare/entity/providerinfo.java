package com.example.healthcare.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
// import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class providerinfo {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String specialty;

        @Column(nullable = false)
        private String contactInfo;

        @OneToMany(mappedBy = "provider")
        private List<userinfo> patients;

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
        public String getSpecialty() {
                return specialty;
        }
        public void setSpecialty(String specialty) {
                this.specialty = specialty; 
        }
        public String getContactInfo() {
                return contactInfo;
        }
        public void setContactInfo(String contactInfo) {
                this.contactInfo = contactInfo;
        }
        public List<userinfo> getPatients() {
                return patients;
        }
        public void setPatients(List<userinfo> patients) {
                this.patients = patients;
        }
}
