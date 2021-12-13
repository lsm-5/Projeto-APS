package com.hotelzin.cinhospede.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelzin.cinhospede.dto.PaymentApiRequest;
import com.hotelzin.cinhospede.dto.PaymentApiResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class PaymentAPIService {
  private String paymentAPIUrl = "http://localhost:3333/payment/cinhospede";

  public Boolean pay(PaymentApiRequest payment) {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();
    String body = "";
    try {
      body = mapper.writeValueAsString(payment);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<>(body, headers);

    PaymentApiResponse response = restTemplate.exchange(paymentAPIUrl, HttpMethod.POST, entity, PaymentApiResponse.class).getBody();
    return response.getStatus().equals("success");
  }
}

