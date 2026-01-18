package com.example.healthcare.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.healthcare.DTO.ProviderAppointmentDTO;
import com.example.healthcare.DTO.ProviderRequestDTO;
import com.example.healthcare.DTO.ProviderResponseDTO;
import com.example.healthcare.DTO.UserRequestDTO;
import com.example.healthcare.DTO.UserResponseDTO;
import com.example.healthcare.DTO.UsergoalsRequestDTO;
import com.example.healthcare.service.HealthCareService;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@RestController
@RequestMapping
public class controller {

        private HealthCareService healthCareService;
        
        controller(HealthCareService healthCareService){
                this.healthCareService=healthCareService;
        }

        @GetMapping("users/{id}/dashboard")
        public ResponseEntity<UserResponseDTO> somestuff(@PathVariable UUID id){
            UserResponseDTO response=healthCareService.getpatientdashboard(id);
            return ResponseEntity.ok().body(response);
        }

        @GetMapping("providers/{id}/dashboard")
        public ResponseEntity<ProviderResponseDTO> getProviders(@PathVariable UUID id){
            ProviderResponseDTO response=healthCareService.getproviderdashboard(id);
            return ResponseEntity.ok().body(response);
        }

        @PostMapping("/users")
    public ResponseEntity<Void> addUser(@Validated({Default.class}) @RequestBody UserRequestDTO requestDTO) {
        healthCareService.createUser(requestDTO);
        return ResponseEntity.noContent().build();
    }


        @PutMapping("/users/{id}")
    public ResponseEntity<Void> updateUser(
            @PathVariable UUID id,
            @Validated({Default.class})
            @RequestBody UserRequestDTO requestDTO) {

        healthCareService.updateUser(id, requestDTO);
        return ResponseEntity.noContent().build();
    }

        @PostMapping("/users/{id}/goals")
    public ResponseEntity<Void> setGoals(
            @PathVariable UUID id,
            @Validated({Default.class})
            @RequestBody UsergoalsRequestDTO requestDTO) {

        healthCareService.setGoals(id, requestDTO);
        return ResponseEntity.noContent().build();
    }

        @PutMapping("/users/{id}/goals")
    public ResponseEntity<UserResponseDTO> updateGoals(
            @PathVariable UUID id,
            @Validated({Default.class})
            @RequestBody UsergoalsRequestDTO requestDTO) {

        UserResponseDTO response = healthCareService.updateGoals(id, requestDTO);
        return ResponseEntity.ok(response);
    }

         @PostMapping("/providers")
    public ResponseEntity<Void> addProvider(
            @Validated({Default.class})
            @RequestBody ProviderRequestDTO requestDTO) {

        healthCareService.createProvider(requestDTO);
        return ResponseEntity.noContent().build();
    }
        
         @PostMapping("/providers/{id}/appointments")
    public ResponseEntity<Void> addProviderAppointment(
            @PathVariable UUID id,
            @Validated({Default.class})
            @RequestBody ProviderAppointmentDTO requestDTO) {

        healthCareService.addAppointment(id, requestDTO);
        return ResponseEntity.noContent().build();
    }

}

