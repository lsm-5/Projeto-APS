package com.hotelzin.cinhospede.collection;

import java.util.List;

import com.hotelzin.cinhospede.model.Hotel;
import com.hotelzin.cinhospede.repositories.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelCollection {
  @Autowired
  private HotelRepository hotelRepository;

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

  public void deleteHotel(Long id) {
    hotelRepository.deleteById(id);
  }
  
}
