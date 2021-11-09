package com.hotelzin.cinhospede.controllers;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;

import com.hotelzin.cinhospede.dto.PaymentCard;
import com.stripe.Stripe;

@Controller
public class ReserveController {
  
  @GetMapping("/hotels/{idHotel}/room/{idRoom}/reserve")
  public ModelAndView show(@PathVariable Long idHotel, @PathVariable Long idRoom, HttpSession session) {
    ModelAndView mv = new ModelAndView("reserve/reserve");
    mv.addObject("idHotel", idHotel);
    mv.addObject("idRoom", idRoom);
    return mv;
  }

  @PostMapping("/hotels/{idHotel}/room/{idRoom}/reserve")
  public ModelAndView reserve(@PathVariable Long idHotel, @PathVariable Long idRoom, HttpSession session, PaymentCard paymentCard) {
    System.out.println(paymentCard);
    ModelAndView mv = new ModelAndView("reserve/reserve");
    Stripe.apiKey = "pk_test_51JtiyFFTKEs3bJ7aX2kHTj5R9syLmnTIjX8FhMlUZEovoaBhNptZP6x03y6NDS479gsXxvrSCaWFc9R4E21X4qUP003ZthbLYl";

    
    return mv;
  }
}
