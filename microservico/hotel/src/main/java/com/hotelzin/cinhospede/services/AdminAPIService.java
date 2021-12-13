package com.hotelzin.cinhospede.services;

import com.hotelzin.cinhospede.dto.AdminApiResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AdminAPIService {

    private String base_url = "http://localhost:8082";

    private WebClient client() {
      return WebClient.builder().baseUrl(base_url).build();
  }

    public AdminApiResponse findByEmailAndPassword(String email, String password) {
      return (AdminApiResponse) 
              client().get()
                .uri("/{email}/{password}/admin", email, password)
                .retrieve()
                .bodyToMono(AdminApiResponse.class).block();
    }
}