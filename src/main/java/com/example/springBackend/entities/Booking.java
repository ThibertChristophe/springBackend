package com.example.springBackend.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "BOOKING")
public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinColumn(name = "user_id") // Pas obligatoire si bien suivit les conventions Spring
  private User user;
  @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinColumn(name = "home_id") // Pas obligatoire si bien suivit les conventions Spring
  private Home home;
  @CreatedDate
  private Date date_created;
  private Date date_selected;

  public Booking() {
  }

  public Booking(int id, User user, Home home,Date date_selected, Date date_created) {
    this.id = id;
    this.user = user;
    this.home = home;
    this.date_selected = date_selected;
    this.date_created = date_created;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Home getHome() {
    return home;
  }

  public void setHome(Home home) {
    this.home = home;
  }

  public Date getDate_created() {
    return date_created;
  }

  public void setDate_created(Date date_created) {
    this.date_created = date_created;
  }

  public Date getDate_selected() {
    return date_selected;
  }

  public void setDate_selected(Date date_selected) {
    this.date_selected = date_selected;
  }
}
