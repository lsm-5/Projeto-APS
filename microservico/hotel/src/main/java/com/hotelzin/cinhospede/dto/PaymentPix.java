package com.hotelzin.cinhospede.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPix extends Payment {
  private String fine = "";
  private String interest = "";
  private String deadLineType = "";
  private String deadLineValue = "";
  private String instruction = "";
}
