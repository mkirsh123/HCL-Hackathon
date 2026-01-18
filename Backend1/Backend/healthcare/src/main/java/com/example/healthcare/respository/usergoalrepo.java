package com.example.healthcare.respository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.healthcare.entity.usergoals;
// import com.example.healthcare.entity.userinfo;

@Repository
public interface usergoalrepo extends JpaRepository<usergoals, UUID> {
    java.util.Optional<usergoals> findByUser_Id(UUID userId);
}
