package com.hotelzin.cinhospede.repositories;

import com.hotelzin.cinhospede.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    
}