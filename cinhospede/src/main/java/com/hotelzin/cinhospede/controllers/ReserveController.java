package com.hotelzin.cinhospede.controllers;

import javax.servlet.http.HttpSession;

import com.hotelzin.cinhospede.Facade;
import com.hotelzin.cinhospede.dto.PaymentCard;
import com.hotelzin.cinhospede.dto.PaymentPix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReserveController {

  @Autowired
  private Facade facade;
  
  @GetMapping("/hotels/{idHotel}/room/{idRoom}/reserve")
  public ModelAndView show(@PathVariable Long idHotel, @PathVariable Long idRoom, HttpSession session) {
    ModelAndView mv = new ModelAndView("reserve/reserve");
    mv.addObject("idHotel", idHotel);
    mv.addObject("idRoom", idRoom);
    return mv;
  }

  @PostMapping("/hotels/{idHotel}/room/{idRoom}/reserve/card")
  public ModelAndView reserve(@PathVariable Long idHotel, @PathVariable Long idRoom, HttpSession session, PaymentCard payment) {
    Boolean response = facade.makeReservation(payment);
    if (response) {
      return new ModelAndView("redirect:/hotels/{idHotel}/room/{idRoom}/reserve/success");
    } else {
      return new ModelAndView("redirect:/hotels/{idHotel}/room/{idRoom}/reserve/failed");
    }
  }

  @PostMapping("/hotels/{idHotel}/room/{idRoom}/reserve/pix")
  public ModelAndView reserve(@PathVariable Long idHotel, @PathVariable Long idRoom, HttpSession session) {
    Boolean response = facade.makeReservation(new PaymentPix());
    if (response) {
      return new ModelAndView("redirect:/hotels/{idHotel}/room/{idRoom}/reserve/success");
    } else {
      return new ModelAndView("redirect:/hotels/{idHotel}/room/{idRoom}/reserve/failed");
    }
  }

  @GetMapping("/hotels/{idHotel}/room/{idRoom}/reserve/success")
  public ModelAndView showSuccess() {
    ModelAndView mv = new ModelAndView("reserve/success");
    return mv;
  }

  @GetMapping("/hotels/{idHotel}/room/{idRoom}/reserve/failed")
  public ModelAndView showFailed() {
    ModelAndView mv = new ModelAndView("reserve/failed");
    return mv;
  }
}
