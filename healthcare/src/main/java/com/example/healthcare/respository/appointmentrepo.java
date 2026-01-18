package com.example.healthcare.respository;

import java.time.LocalDate;
// import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.healthcare.entity.providerappointment;

@Repository
public interface appointmentrepo extends JpaRepository<providerappointment, UUID> {
         List<providerappointment>
    findByUser_IdAndProviderappointmentdateAfterOrderByProviderappointmentdateAsc(
            UUID userId,
            LocalDate date
    );
    List<providerappointment>
    findByProvider_IdOrderByProviderappointmentdateAsc(UUID providerId);

}
