package com.hotelzin.cinhospede.dto;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminApiResponse {
  private String name;
  @Id
  private String email;
  private String password;
}