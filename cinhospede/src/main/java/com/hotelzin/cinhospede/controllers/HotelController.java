package com.hotelzin.cinhospede.controllers;

import java.util.List;

import javax.validation.Valid;

import com.hotelzin.cinhospede.dto.NewHotelDTO;
import com.hotelzin.cinhospede.model.Hotel;
import com.hotelzin.cinhospede.repositories.HotelRepository;

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

  @GetMapping("/hotels")
  public ModelAndView index() {
    ModelAndView mv = new ModelAndView("hotels/index");
    List<Hotel> hotels = hotelRepository.findAll();

    mv.addObject("hotels", hotels);
    return mv;
  }

  @GetMapping("/hotels/new")
  public ModelAndView newHotel() {
    ModelAndView mv = new ModelAndView("hotels/new");
    mv.addObject("newHotelDTO", new NewHotelDTO());
    return mv;
  }

  @PostMapping(value="/hotels")
  public ModelAndView create(@Valid NewHotelDTO newHotel, BindingResult result) {
    if (result.hasErrors()){
      ModelAndView mv = new ModelAndView("hotels/new");
      return mv;
    } else {
      hotelRepository.save(newHotel.toHotel());
      ModelAndView mv = new ModelAndView("redirect:hotels");
      return mv;
    }
  }

  @GetMapping("/hotels/{id}")
  public ModelAndView show(@PathVariable Long id) {

    ModelAndView mv = new ModelAndView("hotels/show");
    Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Hotel não encontrado"));
    
    mv.addObject("hotel", hotel);
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
  public ModelAndView update(@PathVariable Long id, @Valid NewHotelDTO newHotel, BindingResult result) {
    if (result.hasErrors()){
      ModelAndView mv = new ModelAndView("hotels/edit");
      mv.addObject("hotelId", id);
      return mv;
    } else {
      Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Hotel não encontrado"));
      Hotel hotelEdited = newHotel.toHotel(hotel);
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
