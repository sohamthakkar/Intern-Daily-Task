package com.example.springsecurityclient.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    @Column(length =60)
    private String password;
    private  String role;
    private  boolean enable = false;
}
