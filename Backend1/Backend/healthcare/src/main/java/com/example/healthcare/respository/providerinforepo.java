package com.example.healthcare.respository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.healthcare.entity.providerinfo;

@Repository
public interface providerinforepo extends JpaRepository<providerinfo, UUID> {

}
