package com.hotelzin.cinhospede.services;

import java.util.List;

import com.hotelzin.cinhospede.model.Hotel;
import com.hotelzin.cinhospede.model.Room;
import com.hotelzin.cinhospede.repositories.HotelRepository;
import com.hotelzin.cinhospede.repositories.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
  @Autowired
  private HotelRepository hotelRepository;

  @Autowired
  private RoomRepository roomRepository;

  public List<Hotel> findHotels() {
    return hotelRepository.findAll();
  }

  public void saveHotel(Hotel hotel) {
    hotelRepository.save(hotel);
  }

  public Hotel findHotelById(Long id) {
    Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Hotel não encontrado"));
    return hotel;
  }

  public List<Room> getAllRooms(Hotel hotel){
    List<Room> rooms = roomRepository.findAllByHotelRef(hotel.getId());
    return rooms;
  }

  public void deleteHotel(Long id) {
    hotelRepository.deleteById(id);
  }
  
}
