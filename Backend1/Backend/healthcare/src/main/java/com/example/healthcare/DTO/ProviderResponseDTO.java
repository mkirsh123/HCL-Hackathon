package com.example.healthcare.DTO;

// package com.example.healthcare.DTO;

import java.util.List;
import java.util.UUID;

import com.example.healthcare.entity.providerappointment;

public class ProviderResponseDTO {

    private UUID id;
    private String name;

    private List<UserResponseDTO> patients;
    private List<providerappointment> appointments;

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

    public List<UserResponseDTO> getPatients() {
        return patients;
    }

    public void setPatients(List<UserResponseDTO> patients) {
        this.patients = patients;
    }

    public List<providerappointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<providerappointment> appointments) {
        this.appointments = appointments;
    }
}

