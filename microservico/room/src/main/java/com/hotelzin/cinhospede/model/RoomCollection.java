package com.hotelzin.cinhospede.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomCollection {

  @Autowired
  private RoomRepository roomRepository;

  public void saveRoom(Room room) {
    roomRepository.save(room);
  }

  public List<Room> getAllRooms(Long id){
    List<Room> rooms = roomRepository.findAllByHotelRef(id);
    return rooms;
  }
}
