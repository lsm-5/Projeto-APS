package com.hotelzin.cinhospede.services.adapter;

import com.hotelzin.cinhospede.dto.Payment;
import com.hotelzin.cinhospede.dto.PaymentApiRequest;
import com.hotelzin.cinhospede.dto.PaymentCard;
import com.hotelzin.cinhospede.dto.PaymentPix;
import com.hotelzin.cinhospede.services.PaymentAPIService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentAPIAdapter {
  @Autowired
  private PaymentAPIService paymentAPIService;

  public Boolean pay(Payment payment) {
    PaymentApiRequest request = null;

    if (payment instanceof PaymentCard) {
      request = new PaymentApiRequest((PaymentCard) payment);
    } else if(payment instanceof PaymentPix) {
      request = new PaymentApiRequest((PaymentPix) payment);
    }

    return paymentAPIService.pay(request);
  }
   
}
