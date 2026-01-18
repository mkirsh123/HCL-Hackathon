package com.example.healthcare.respository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.healthcare.entity.userinfo;

@Repository
public interface userinforepo extends JpaRepository<userinfo, UUID> {
         List<userinfo> findByProvider_Id(UUID providerId);  

}
