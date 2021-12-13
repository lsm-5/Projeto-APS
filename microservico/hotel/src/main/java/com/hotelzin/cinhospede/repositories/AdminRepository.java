package com.hotelzin.cinhospede.repositories;

import com.hotelzin.cinhospede.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
    public Admin findByEmailAndPassword(String Email, String password);
}