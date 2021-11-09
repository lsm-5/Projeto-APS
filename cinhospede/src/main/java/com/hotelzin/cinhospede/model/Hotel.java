package com.hotelzin.cinhospede.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;
  private String photo;
  private String address;
  private String adminRef;

  public Hotel(String name, String description, String photo, String address, String adminRef) {
    this.name = name;
    this.description = description;
    this.photo = photo;
    this.address = address;
    this.adminRef = adminRef;
  }
}