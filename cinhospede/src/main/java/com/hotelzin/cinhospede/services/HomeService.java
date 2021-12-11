package com.hotelzin.cinhospede.services;

import com.hotelzin.cinhospede.collection.HomeCollection;
import com.hotelzin.cinhospede.model.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
  @Autowired
  private HomeCollection homeCollection;

  public Admin login(String email, String senha) {
    return homeCollection.login(email, senha);
  }
  
}
