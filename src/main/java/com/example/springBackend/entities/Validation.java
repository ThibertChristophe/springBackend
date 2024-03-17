package com.example.springBackend.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "VALIDATION")
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Instant created;
    private Instant activated;
    private Instant expires;
    private String code;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;


    public Validation(Instant created, Instant expires, String code, User user) {
        this.created = created;
        this.expires = expires;
        this.code = code;
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getActivated() {
        return activated;
    }

    public void setActivated(Instant activated) {
        this.activated = activated;
    }

    public Instant getExpires() {
        return expires;
    }

    public void setExpires(Instant expires) {
        this.expires = expires;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
