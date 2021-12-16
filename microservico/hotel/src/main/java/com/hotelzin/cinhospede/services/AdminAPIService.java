package com.hotelzin.cinhospede.services;

import com.hotelzin.cinhospede.dto.AdminApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AdminAPIService {

  @Autowired WebClient.Builder wBuilder;

  private WebClient client() {
    return wBuilder.baseUrl("lb://admin").build();
  }

    public AdminApiResponse findByEmailAndPassword(String email, String password) {
      return (AdminApiResponse) 
              client().get()
                .uri("/admin/{email}/{password}", email, password)
                .retrieve()
                .bodyToMono(AdminApiResponse.class).block();
    }
}