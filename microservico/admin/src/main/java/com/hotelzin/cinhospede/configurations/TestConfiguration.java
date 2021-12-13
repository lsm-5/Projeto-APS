package com.hotelzin.cinhospede.configurations;

import com.hotelzin.cinhospede.model.Admin;
import com.hotelzin.cinhospede.model.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration implements CommandLineRunner {
  @Autowired
  private AdminRepository adminRepository;

  @Override
  public void run(String... args) throws Exception {
    adminRepository.save(new Admin("Lucas Mendonça", "lsm5@cin.ufpe.br", "lsm5"));
  }
  
}
