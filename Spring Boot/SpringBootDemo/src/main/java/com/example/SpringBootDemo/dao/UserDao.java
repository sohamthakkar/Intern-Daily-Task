package com.example.SpringBootDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootDemo.model.UserModel;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserModel, Integer> {

}
