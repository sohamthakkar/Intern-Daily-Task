package com.example.springsecurityclient.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@ToString
@NoArgsConstructor
public class VerificationToken {

    //expiration time
    private static final int EXPIRATION_TME = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private Date expireyToken;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false, foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))
    private User user;

    public VerificationToken(User user, String token){
        super();
        this.token = token;
        this.user = user;
        this.expireyToken = calculateExpirationDate(EXPIRATION_TME);
    }
    public VerificationToken(String token) {
        super();
        this.token = token;
        this.expireyToken = calculateExpirationDate(EXPIRATION_TME);
    }

    private Date calculateExpirationDate(int expirationTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expirationTime);
        return new Date(calendar.getTime().getTime());
    }
}
