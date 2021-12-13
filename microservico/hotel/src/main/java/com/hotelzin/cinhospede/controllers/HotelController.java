package com.hotelzin.cinhospede.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.hotelzin.cinhospede.Facade;
import com.hotelzin.cinhospede.dto.NewHotelDTO;
import com.hotelzin.cinhospede.dto.Room;
import com.hotelzin.cinhospede.model.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HotelController {
  
  @Autowired
  private Facade facade;


  @GetMapping("/hotels")
  public ModelAndView index() {
    ModelAndView mv = new ModelAndView("hotels/index");
    List<Hotel> hotels = facade.findHotels();
    mv.addObject("hotels", hotels);
    return mv;
  }

  @GetMapping("/hotels/new")
  public ModelAndView newHotel(HttpSession session) {
    ModelAndView mv = new ModelAndView("hotels/new");
    mv.addObject("newHotelDTO", new NewHotelDTO());
    return mv;
  }

  @PostMapping(value="/hotels")
  public ModelAndView create(@Valid NewHotelDTO newHotel, BindingResult result, HttpSession session) {
    String email = (String) session.getAttribute("email");
    if (result.hasErrors()){
      ModelAndView mv = new ModelAndView("hotels/new");
      return mv;
    } else {
      facade.saveHotel(newHotel.toHotel(email));
      ModelAndView mv = new ModelAndView("redirect:hotels");
      return mv;
    }
  }

  @GetMapping("/hotels/{id}")
  public ModelAndView show(@PathVariable Long id) {
    ModelAndView mv = new ModelAndView("hotels/show");
    Hotel hotel = facade.findHotelById(id);
    List<Room> rooms = facade.getAllRooms(hotel);
    mv.addObject("hotel", hotel);
    mv.addObject("rooms", rooms);
    return mv;
  }

  @GetMapping("/hotels/{id}/edit")
  public ModelAndView edit(@PathVariable Long id, NewHotelDTO newHotelDTO) {
    ModelAndView mv = new ModelAndView("hotels/edit");
    Hotel hotel = facade.findHotelById(id);
    newHotelDTO.fromHotel(hotel);
    mv.addObject("hotelId", hotel.getId());
    return mv;
  }

  @PostMapping(value="/hotels/{id}")
  public ModelAndView update(@PathVariable Long id, @Valid NewHotelDTO newHotel, BindingResult result, HttpSession session) {
    if (result.hasErrors()){
      ModelAndView mv = new ModelAndView("hotels/edit");
      mv.addObject("hotelId", id);
      return mv;
    } else {
      Hotel hotel = facade.findHotelById(id);
      Hotel hotelEdited = newHotel.toHotel(hotel);
      facade.saveHotel(hotelEdited);
      ModelAndView mv = new ModelAndView("redirect:/hotels/" + id);
      return mv;
    }
  }

  @GetMapping("/hotels/{id}/delete")
  public ModelAndView delete(@PathVariable Long id, NewHotelDTO newHotelDTO) {
    try {
      facade.deleteHotel(id);
      ModelAndView mv = new ModelAndView("redirect:/hotels");
      return mv;
    }catch(EmptyResultDataAccessException e){
      System.out.println(e);
      ModelAndView mv = new ModelAndView("redirect:/hotels");
      return mv;
    }
  }
}
