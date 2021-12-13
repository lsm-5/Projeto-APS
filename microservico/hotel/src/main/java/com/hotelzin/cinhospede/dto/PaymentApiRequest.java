package com.hotelzin.cinhospede.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class PaymentApiRequest implements Serializable{
  private String paymentType;

  private String fine;
  private String interest;
  private String deadLineType;
  private String deadLineValue;
  private String instruction;

  private String cardName;
  private String cardNumber;
  private String cardYearExpiration;
  private String cardMonthExpiration;
  private String cardCvv;
  private String cardFlag;

  public PaymentApiRequest(PaymentCard paymentCard) {
    this.paymentType = "card";
    this.cardName = paymentCard.getCardName();
    this.cardNumber = paymentCard.getCardNumber();
    this.cardYearExpiration = paymentCard.getCardYearExpiration();
    this.cardMonthExpiration = paymentCard.getCardMonthExpiration();
    this.cardCvv = paymentCard.getCardCvv();
    this.cardFlag = paymentCard.getCardFlag();
  }

  public PaymentApiRequest(PaymentPix paymentPix) {
    this.paymentType = "pix";
    this.fine = paymentPix.getFine();
    this.interest = paymentPix.getInterest();
    this.deadLineType = paymentPix.getDeadLineType();
    this.deadLineValue = paymentPix.getDeadLineValue();
    this.instruction = paymentPix.getInstruction();
  }
}
