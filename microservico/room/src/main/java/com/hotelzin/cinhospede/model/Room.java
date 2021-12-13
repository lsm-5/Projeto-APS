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
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;
  private Long hotelRef;
  private double value;
  private int numberOfSingleBeds;
  private int numberOfDoubleBeds;
  private String photo;
  private int numberOfPeoples;
  private Boolean hasSuite;

  public Room(
    String name, 
    String description, 
    Long hotelRef, 
    double value, 
    int numberOfSingleBeds, 
    int numberOfDoubleBeds, 
    String photo, 
    int numberOfPeoples, 
    Boolean hasSuite) {
    this.name = name;
    this.description = description;
    this.hotelRef = hotelRef;
    this.value = value;
    this.numberOfSingleBeds = numberOfSingleBeds;
    this.numberOfDoubleBeds = numberOfDoubleBeds;
    this.photo = photo;
    this.numberOfPeoples = numberOfPeoples;
    this.hasSuite = hasSuite;
  }
}