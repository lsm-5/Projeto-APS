package com.hotelzin.cinhospede.dto;

import java.util.List;

import com.hotelzin.cinhospede.model.Room;

import lombok.Data;

@Data
public class RoomApiResponse {
  private List <Room> rooms;
}
