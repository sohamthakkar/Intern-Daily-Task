package com.example.userorg.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long userId;

    @NotEmpty(message = "User Name Must Required")
    @Column(name = "user_name")
    private String userName;

    @NotEmpty(message = "User Email Must Required")
    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "mobile")
    @NotEmpty(message = "User Mobile Must Required")
    private String userMobile;

    public User(String userName, String userEmail, String userMobile) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
    }
}
