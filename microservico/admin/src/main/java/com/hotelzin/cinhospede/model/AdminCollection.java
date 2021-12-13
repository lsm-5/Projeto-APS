package com.hotelzin.cinhospede.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminCollection {

  @Autowired
  private AdminRepository adminRepository;

  public void saveAdmin(Admin admin) {
    adminRepository.save(admin);
  }

  public Admin findByEmailAndPassword(String email, String password){
   return adminRepository.findByEmailAndPassword(email, password);
  }
}
