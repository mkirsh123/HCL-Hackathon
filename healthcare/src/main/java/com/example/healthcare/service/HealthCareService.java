package com.example.healthcare.service;

import java.util.UUID;

// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.example.healthcare.DTO.ProviderAppointmentDTO;
import com.example.healthcare.DTO.ProviderRequestDTO;
import com.example.healthcare.DTO.ProviderResponseDTO;
import com.example.healthcare.DTO.UserRequestDTO;
import com.example.healthcare.DTO.UserResponseDTO;
import com.example.healthcare.DTO.UsergoalsRequestDTO;
import com.example.healthcare.model.repoconfig;

@Service
public class HealthCareService {

            repoconfig Repoconfig;
            HealthCareService(repoconfig repoconfig){
                this.Repoconfig= repoconfig;
            }

             public void createUser(UserRequestDTO requestDTO) {
             Repoconfig.createUser(requestDTO);
    }

    public void updateUser(UUID id, UserRequestDTO requestDTO) {
        Repoconfig.updateUser(id, requestDTO);
    }

    public void setGoals(UUID id, UsergoalsRequestDTO requestDTO) {
        Repoconfig.setUserGoals(id, requestDTO);
    }

    public UserResponseDTO updateGoals(UUID id, UsergoalsRequestDTO requestDTO) {
        Repoconfig.updateUserGoals(id, requestDTO);
        return Repoconfig.getUserResponse(id);
    }


            public UserResponseDTO getpatientdashboard(UUID ID){
                    UserResponseDTO userResponseDTO= new UserResponseDTO();
                    userResponseDTO=Repoconfig.getUserResponse(ID);
                    return userResponseDTO;
            }

            public void createProvider(ProviderRequestDTO requestDTO) {
        Repoconfig.createProvider(requestDTO);
    }

    public void addAppointment(UUID providerId, ProviderAppointmentDTO requestDTO) {
        Repoconfig.addAppointment(providerId, requestDTO);
    }

            public ProviderResponseDTO getproviderdashboard(UUID ID){
                    ProviderResponseDTO providerResponseDTO= new ProviderResponseDTO();
                    providerResponseDTO=Repoconfig.getProviderResponse(ID);
                    return providerResponseDTO;
            }
}
