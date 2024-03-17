package com.example.springBackend.services;

import com.example.springBackend.entities.Validation;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    JavaMailSender javaMailSender;

    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(Validation validation){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("no-rely@test.com");
        simpleMailMessage.setTo(validation.getUser().getEmail());
        simpleMailMessage.setSubject("Validation code");
        String text = String.format("Bonjour %s, <br /> Vode code : %s", validation.getUser().getUsername(), validation.getCode());
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
    }
}
