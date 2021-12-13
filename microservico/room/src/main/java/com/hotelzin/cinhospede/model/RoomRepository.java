package com.hotelzin.cinhospede.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
  public List<Room> findAllByHotelRef(Long hotelRef);
}