package com.example.security.springsecurityauthserver.services;

import com.example.security.springsecurityauthserver.model.CustomUserDetails;
import com.example.security.springsecurityauthserver.model.Users;
import com.example.security.springsecurityauthserver.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> usersOptinal = usersRepository.findByName(username);
        usersOptinal.orElseThrow(()-> new UsernameNotFoundException("User name not found"));
        return usersOptinal
                .map(CustomUserDetails::new)
                .get();
    }
}
