package com.hotelzin.cinhospede.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.hotelzin.cinhospede.model.Hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewHotelDTO {
  @NotBlank(message = "Nome é obrigatório")
  @NotNull
  private String name;


  private String description;
  private String photo;

  @NotBlank(message = "Endereço é obrigatório")
  @NotNull
  private String address;
  

  // @notnull @decimalmin("0.0")
  public Hotel toHotel() {
    return new Hotel(name, description, photo, address);
  }

  public Hotel toHotel(Hotel hotel) {
    hotel.setName(this.name);
    hotel.setDescription(this.description);
    hotel.setPhoto(this.photo);
    hotel.setAddress(this.address);
    return hotel;
  }

  public void fromHotel(Hotel hotel) {
    this.name = hotel.getName();
    this.description = hotel.getDescription();
    this.photo = hotel.getPhoto();
    this.address = hotel.getAddress();
  }

}
