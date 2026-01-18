package com.example.healthcare.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.healthcare.DTO.ProviderAppointmentDTO;
import com.example.healthcare.DTO.ProviderRequestDTO;
import com.example.healthcare.DTO.ProviderResponseDTO;
import com.example.healthcare.DTO.RemaindersDTO;
import com.example.healthcare.DTO.UserGoalsResponseDTO;
import com.example.healthcare.DTO.UserRequestDTO;
import com.example.healthcare.DTO.UserResponseDTO;
import com.example.healthcare.DTO.UsergoalsRequestDTO;
import com.example.healthcare.entity.providerappointment;
import com.example.healthcare.entity.providerinfo;
import com.example.healthcare.entity.usergoals;
import com.example.healthcare.entity.userinfo;
import com.example.healthcare.respository.appointmentrepo;
import com.example.healthcare.respository.providerinforepo;
import com.example.healthcare.respository.tiprepo;
import com.example.healthcare.respository.usergoalrepo;
import com.example.healthcare.respository.userinforepo;

@Component
public class repoconfig {
        private appointmentrepo Appointmentrepo;
        private providerinforepo Providerinforepo;
        private tiprepo Tiprepo;
        private userinforepo Userinforepo;
        private usergoalrepo Usergoalrepo;

        public repoconfig(appointmentrepo appointmentrepo, providerinforepo providerinforepo,
                        tiprepo tiprepo, userinforepo userinforepo, usergoalrepo usergoalrepo) {
                Appointmentrepo = appointmentrepo;
                Providerinforepo = providerinforepo;
                Tiprepo = tiprepo;
                Userinforepo = userinforepo;
                Usergoalrepo = usergoalrepo;
        }

        public void createUser(UserRequestDTO dto) {
        userinfo user = new userinfo();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setDateOfBirth(dto.getDateOfBirth());

        providerinfo provider = Providerinforepo.findById(dto.getProviderId())
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        user.setProvider(provider);
        Userinforepo.save(user);
    }

        public void updateUser(UUID id, UserRequestDTO dto) {
        userinfo user = Userinforepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.getName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setDateOfBirth(dto.getDateOfBirth());

        Userinforepo.save(user);
    }
        public void setUserGoals(UUID userId, UsergoalsRequestDTO dto) {
        usergoals goals = new usergoals();
        goals.setDailyStepGoal(dto.getSteps());
        goals.setActiveTimeGoal(dto.getActiveTimeInMinutes());
        goals.setSleeptime(dto.getSleeptime());
        Usergoalrepo.save(goals);
    }

    public void updateUserGoals(UUID userId, UsergoalsRequestDTO dto) {
        usergoals goals = Usergoalrepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Goals not found"));

        goals.setDailyStepGoal(dto.getSteps());
        goals.setActiveTimeGoal(dto.getActiveTimeInMinutes());
        goals.setSleeptime(dto.getSleeptime());

        Usergoalrepo.save(goals);
    }

    public UserResponseDTO getUserResponse(UUID userId) {

    userinfo user = Userinforepo.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

    usergoals goal = Usergoalrepo.findById(userId)
            .orElseThrow(() -> new RuntimeException("User goals not found"));

    UserGoalsResponseDTO goalsDTO = new UserGoalsResponseDTO();
    goalsDTO.setSteps(goal.getDailyStepGoal());
    goalsDTO.setActiveTimeInMinutes(goal.getActiveTimeGoal());
    goalsDTO.setSleeptime(goal.getSleeptime());

    LocalDateTime now = LocalDateTime.now();

    List<providerappointment> appointments =
            Appointmentrepo.findByUser_IdAndProviderappointmentdateAfter(
                    userId, now.toLocalDate());

    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    List<String> items = appointments.stream()
            .map(a ->
                    a.getUser().getName() +
                    " at " +
                    a.getProviderappointmentdate().format(formatter)
            )
            .toList();

    RemaindersDTO remaindersDTO = new RemaindersDTO();
    remaindersDTO.setItems(items);
    remaindersDTO.setReturned(items.size());
    remaindersDTO.setTotal(items.size());

    String tip = Tiprepo.findRandomTip();

    UserResponseDTO response = new UserResponseDTO();
    response.setId(user.getId());
    response.setName(user.getName());
    response.setGoals(goalsDTO);
    response.setRemainders(remaindersDTO);
    response.setTip(tip);

    return response;
}

    public void createProvider(ProviderRequestDTO dto) {
        providerinfo provider = new providerinfo();
        provider.setName(dto.getName());
        provider.setSpecialty(dto.getSpecialty());
        provider.setContactInfo(dto.getContactInfo());

        Providerinforepo.save(provider);
    }

    public void addAppointment(UUID providerId, ProviderAppointmentDTO dto) {
        providerappointment appointment = new providerappointment();

        providerinfo provider = Providerinforepo.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        userinfo user = Userinforepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        appointment.setProvider(provider);
        appointment.setUser(user);
        appointment.setProviderappointmentdate(dto.getTime());

        Appointmentrepo.save(appointment);
    }


   public ProviderResponseDTO getProviderResponse(UUID providerId) {

    providerinfo provider = Providerinforepo.findById(providerId)
            .orElseThrow(() -> new RuntimeException("Provider not found"));

    List<userinfo> users =
            Userinforepo.findByProviderId(providerId);

    List<UserResponseDTO> patientDTOs = users.stream()
            .map(user -> {
                UserResponseDTO dto = new UserResponseDTO();
                dto.setId(user.getId());
                dto.setName(user.getName());
                return dto;
            })
            .toList();

    List<providerappointment> appointments =
            Appointmentrepo.findByProvider_IdOrderByProviderappointmentdateAsc(providerId);

    ProviderResponseDTO response = new ProviderResponseDTO();
    response.setId(provider.getId());
    response.setName(provider.getName());
    response.setPatients(patientDTOs);
    response.setAppointments(appointments);

    return response;
}


}