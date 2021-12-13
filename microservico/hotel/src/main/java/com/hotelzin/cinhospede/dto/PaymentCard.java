package com.hotelzin.cinhospede.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCard extends Payment {
  private String cardName;
  private String cardNumber;
  private String cardYearExpiration;
  private String cardMonthExpiration;
  private String cardCvv;
  private String cardFlag;
}
