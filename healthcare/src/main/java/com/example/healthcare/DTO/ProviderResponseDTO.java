package com.example.healthcare.DTO;

// package com.example.healthcare.DTO;

import java.util.List;
import java.util.UUID;

import com.example.healthcare.entity.providerappointment;
// import com.example.healthcare.entity.userinfo;

public class ProviderResponseDTO {

    private UUID id;
    private String name;

    private List<userdto> patients;
    private List<appointmentdto> appointments;

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

    public List<userdto> getPatients() {
        return patients;
    }

    public void setPatients(List<userdto> patients) {
        this.patients = patients;
    }

    public List<appointmentdto> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<appointmentdto> appointments) {
        this.appointments = appointments;
    }
}

