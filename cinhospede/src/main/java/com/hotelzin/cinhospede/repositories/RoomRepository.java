package com.hotelzin.cinhospede.repositories;

import java.util.List;

import com.hotelzin.cinhospede.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
  public List<Room> findAllByHotelRef(Long hotelRef);

}