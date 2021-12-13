package com.hotelzin.cinhospede.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminController {
  @Autowired private AdminCollection adminCollection;

  public Admin findByEmailAndPassword(String email, String password) {
    return adminCollection.findByEmailAndPassword(email, password);
  }
}
