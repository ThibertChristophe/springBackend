package com.example.springBackend.services;

import com.example.springBackend.entities.User;
import com.example.springBackend.entities.Validation;
import com.example.springBackend.repositories.ValidationRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Service
public class ValidationService {
    private final ValidationRepository validationRepository;
    private final NotificationService notificationService;

    public ValidationService(ValidationRepository validationRepository, NotificationService notificationService) {
        this.validationRepository = validationRepository;
        this.notificationService = notificationService;
    }

    // Crée la validation en attente et envoi le mail avec le code de validation
    public void register(User user){
        Instant created = Instant.now();
        Instant expires = created.plus(10, ChronoUnit.MINUTES);
        Random random = new Random();
        int randomInt = random.nextInt(999999);
        String code = String.format("%06d", randomInt);
        Validation validation = new Validation(created,expires,code,user);
        this.validationRepository.save(validation);
        this.notificationService.send(validation);
    }
}
