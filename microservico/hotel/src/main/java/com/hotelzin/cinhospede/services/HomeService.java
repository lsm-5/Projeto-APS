package com.hotelzin.cinhospede.services;

import com.hotelzin.cinhospede.dto.AdminApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
  @Autowired
  private AdminAPIService adminAPIService;

  public AdminApiResponse findByEmailAndPassword(String email, String senha) {
    return adminAPIService.findByEmailAndPassword(email, senha);
  }
  
}
