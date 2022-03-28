package com.example.springsecurityclient.dao;

import com.example.springsecurityclient.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationUserRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
}
