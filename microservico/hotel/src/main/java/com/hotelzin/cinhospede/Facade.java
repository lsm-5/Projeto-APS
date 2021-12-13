package com.hotelzin.cinhospede;

import java.util.List;

import com.hotelzin.cinhospede.dto.AdminApiResponse;
import com.hotelzin.cinhospede.dto.Payment;
import com.hotelzin.cinhospede.dto.Room;
import com.hotelzin.cinhospede.model.Hotel;
import com.hotelzin.cinhospede.services.HomeService;
import com.hotelzin.cinhospede.services.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Facade {
  
  @Autowired
  private HomeService homeService;

  @Autowired
  private HotelService hotelService;

  public AdminApiResponse login(String email, String senha) {
    return homeService.findByEmailAndPassword(email, senha);
  }

  public List<Hotel> findHotels() {
    return hotelService.findHotels();
  }

  public void saveHotel(Hotel hotel) {
    hotelService.saveHotel(hotel);
  }

  public Hotel findHotelById(Long id) {
    Hotel hotel = hotelService.findHotelById(id);
    return hotel;
  }

  public List<Room> getAllRooms(Hotel hotel){
    List<Room> rooms = hotelService.getAllRooms(hotel);
    return rooms;
  }

  public void deleteHotel(Long id) {
    hotelService.deleteHotel(id);
  }

  public Boolean makeReservation(Payment payment){
    return hotelService.makeReservation(payment);
  }

}
