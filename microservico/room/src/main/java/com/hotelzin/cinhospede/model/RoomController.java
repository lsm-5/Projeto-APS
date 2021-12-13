package com.hotelzin.cinhospede.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomController {
  @Autowired private RoomCollection roomCollection;

  public List<Room> getAllRooms(Long hotelId) {
    return roomCollection.getAllRooms(hotelId);
  }
}
