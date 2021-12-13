package com.hotelzin.cinhospede.services;

import java.util.List;
import java.util.stream.Collectors;

import com.hotelzin.cinhospede.dto.Room;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class RoomAPIService {

    private String base_url = "http://localhost:8080";

    private WebClient client() {
      return WebClient.builder().baseUrl(base_url).build();
  }

    public List<Room> getAllRoom(Long hotelId) {
      Mono<List<Room>> response = client().get()
          .uri("/{hotelId}/rooms", hotelId)
          .retrieve()
          .bodyToMono(new ParameterizedTypeReference<List<Room>>() {});

      List<Room> rooms = response.block();
      
      return rooms.stream().collect(Collectors.toList());
    }
}