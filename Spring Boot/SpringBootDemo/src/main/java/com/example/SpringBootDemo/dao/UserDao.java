package com.example.SpringBootDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootDemo.model.UserModel;

public interface UserDao extends JpaRepository<UserModel, Integer> {

}
