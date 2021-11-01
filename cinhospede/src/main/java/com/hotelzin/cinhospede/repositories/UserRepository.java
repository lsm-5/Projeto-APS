package com.hotelzin.cinhospede.repositories;

import com.hotelzin.cinhospede.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByEmail(String email);
    
}