package com.example.springsecurityclient.event.listner;

import com.example.springsecurityclient.entity.User;
import com.example.springsecurityclient.event.RegistrationCompleteEvent;
import com.example.springsecurityclient.services.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegisterCompleteEventListner implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserServices userServices;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //create application token with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userServices.saveVerificationTokenForUser(token,user);
        //Send Mail to user
        String url =
                event.getApplicationUrl()
                        + "/verifyRegistration?token="
                        + token;
        //Send Verfication Email
        log.info("Click url to verify: " + url);
    }
}
