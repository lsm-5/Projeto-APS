package com.hotelzin.cinhospede.services;

import java.util.List;
import java.util.stream.Collectors;

import com.hotelzin.cinhospede.dto.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class RoomAPIService {

  @Autowired WebClient.Builder wBuilder;

  private WebClient client() {
    return wBuilder.baseUrl("lb://room").build();
  }

  public List<Room> getAllRoom(Long hotelId) {
    Mono<List<Room>> response = client().get()
        .uri("/rooms/{hotelId}", hotelId)
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<Room>>() {});

    List<Room> rooms = response.block();
      
    return rooms.stream().collect(Collectors.toList());
  }
}