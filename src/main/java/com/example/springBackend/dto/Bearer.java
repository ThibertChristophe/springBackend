package com.example.springBackend.dto;

public class Bearer {
private String token;

    public Bearer(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
