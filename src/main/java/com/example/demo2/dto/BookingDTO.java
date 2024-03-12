package com.example.demo2.dto;

public class BookingDTO {

  private int user_id;
  private int home_id;

  public BookingDTO(int user_id, int home_id) {
    this.user_id = user_id;
    this.home_id = home_id;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public int getHome_id() {
    return home_id;
  }

  public void setHome_id(int home_id) {
    this.home_id = home_id;
  }

}
