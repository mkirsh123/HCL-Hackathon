package com.example.healthcare.respository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.healthcare.entity.tipofday;

// import com.example.healthcare.entity.userinfo;

@Repository
public interface tiprepo extends JpaRepository<tipofday, UUID> {
    @org.springframework.data.jpa.repository.Query(
        value = "SELECT tip_content FROM tipofday ORDER BY RANDOM() LIMIT 1",
        nativeQuery = true
    )
    String findRandomTip();
}
