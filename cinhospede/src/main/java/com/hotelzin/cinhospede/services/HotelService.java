package com.hotelzin.cinhospede.services;

import java.util.List;

import com.hotelzin.cinhospede.collection.HotelCollection;
import com.hotelzin.cinhospede.model.Hotel;
import com.hotelzin.cinhospede.model.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
  @Autowired
  private HotelCollection hotelCollection;

  public List<Hotel> findHotels() {
    return hotelCollection.findHotels();
  }

  public void saveHotel(Hotel hotel) {
    hotelCollection.saveHotel(hotel);
  }

  public Hotel findHotelById(Long id) {
    Hotel hotel = hotelCollection.findHotelById(id);
    return hotel;
  }

  public List<Room> getAllRooms(Hotel hotel){
    List<Room> rooms = hotelCollection.getAllRooms(hotel);
    return rooms;
  }

  public void deleteHotel(Long id) {
    hotelCollection.deleteHotel(id);
  }
  
}
