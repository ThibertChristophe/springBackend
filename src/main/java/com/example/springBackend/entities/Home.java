
package com.example.springBackend.entities;

import com.example.springBackend.enums.TypeHome;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "HOME")
public class Home {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(unique = true)
  private String street;
  private String name;
  private String city;
  private String state;
  private int availableUnits;
  private boolean wifi;
  private boolean laundry;
  private TypeHome type;
  @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinColumn(name = "USER_ID") // Pas obligatoire si bien suivit les conventions Spring
  private User user;

  public Home() {
  }

  public Home(int id, String street, String name, String city, String state, int availableUnits, boolean wifi,
      boolean laundry, TypeHome type, User user) {
    this.id = id;
    this.street = street;
    this.name = name;
    this.city = city;
    this.state = state;
    this.availableUnits = availableUnits;
    this.wifi = wifi;
    this.laundry = laundry;
    this.type = type;
    this.user = user;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public TypeHome getType() {
    return type;
  }

  public void setType(TypeHome type) {
    this.type = type;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public int getAvailableUnits() {
    return availableUnits;
  }

  public void setAvailableUnits(int availableUnits) {
    this.availableUnits = availableUnits;
  }

  public boolean isWifi() {
    return wifi;
  }

  public void setWifi(boolean wifi) {
    this.wifi = wifi;
  }

  public boolean isLaundry() {
    return laundry;
  }

  public void setLaundry(boolean laundry) {
    this.laundry = laundry;
  }

}
