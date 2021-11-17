package com.hotelzin.cinhospede.services;

import com.hotelzin.cinhospede.model.Admin;
import com.hotelzin.cinhospede.repositories.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
  @Autowired
  private AdminRepository adminRepository;

  public Admin login(String email, String senha) {
    return adminRepository.findByEmailAndPassword(email, senha);
  }
  
}
