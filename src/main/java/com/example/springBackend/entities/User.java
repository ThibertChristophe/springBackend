package com.example.springBackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public class User{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(unique = true)
  private String email;
  private String phoneNumber;
  @Column(unique = true)
  private String username;
  private String password;
  private boolean enabled = false;
  @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private Role role;

  public User() {
  }

  public User(int id, String email, String phoneNumber, String username, String password, boolean enabled, Role role) {
    this.id = id;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.role = role;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return this.username;
  }

  public boolean isEnabled() {
    return this.enabled;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

}
