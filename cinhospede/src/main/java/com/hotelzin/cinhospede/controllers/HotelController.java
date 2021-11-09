package com.hotelzin.cinhospede.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.hotelzin.cinhospede.dto.NewHotelDTO;
import com.hotelzin.cinhospede.model.Admin;
import com.hotelzin.cinhospede.model.Hotel;
import com.hotelzin.cinhospede.model.Room;
import com.hotelzin.cinhospede.repositories.HotelRepository;
import com.hotelzin.cinhospede.repositories.RoomRepository;

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
  private HotelRepository hotelRepository;

  @Autowired
  private RoomRepository roomRepository;

  @GetMapping("/hotels")
  public ModelAndView index() {
    ModelAndView mv = new ModelAndView("hotels/index");
    List<Hotel> hotels = hotelRepository.findAll();

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
    System.out.println("result:" + result);
    if (result.hasErrors()){
      ModelAndView mv = new ModelAndView("hotels/new");
      return mv;
    } else {
      hotelRepository.save(newHotel.toHotel(email));
      ModelAndView mv = new ModelAndView("redirect:hotels");
      return mv;
    }
  }

  @GetMapping("/hotels/{id}")
  public ModelAndView show(@PathVariable Long id) {

    ModelAndView mv = new ModelAndView("hotels/show");
    Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Hotel não encontrado"));
    List<Room> rooms = roomRepository.findAllByHotelRef(hotel.getId());

    mv.addObject("hotel", hotel);
    mv.addObject("rooms", rooms);

    return mv;
  }

  @GetMapping("/hotels/{id}/edit")
  public ModelAndView edit(@PathVariable Long id, NewHotelDTO newHotelDTO) {
    ModelAndView mv = new ModelAndView("hotels/edit");
    Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Hotel não encontrado"));
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
      Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Hotel não encontrado"));
      Hotel hotelEdited = newHotel.toHotel(hotel);
      System.out.println("hotelEdited:" + hotelEdited);
      hotelRepository.save(hotelEdited);

      ModelAndView mv = new ModelAndView("redirect:/hotels/" + id);
      return mv;
    }
  }

  @GetMapping("/hotels/{id}/delete")
  public ModelAndView delete(@PathVariable Long id, NewHotelDTO newHotelDTO) {
    try {
      hotelRepository.deleteById(id);
      ModelAndView mv = new ModelAndView("redirect:/hotels");
      return mv;
    }catch(EmptyResultDataAccessException e){
      System.out.println(e);
      ModelAndView mv = new ModelAndView("redirect:/hotels");
      return mv;
    }
  }
}
