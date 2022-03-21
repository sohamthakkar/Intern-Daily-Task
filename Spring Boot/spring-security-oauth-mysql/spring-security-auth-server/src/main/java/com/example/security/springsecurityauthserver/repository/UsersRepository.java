package com.example.security.springsecurityauthserver.repository;

import com.example.security.springsecurityauthserver.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
