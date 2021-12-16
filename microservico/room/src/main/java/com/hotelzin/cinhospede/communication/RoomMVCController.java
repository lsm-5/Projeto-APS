package com.hotelzin.cinhospede.communication;

import java.util.List;

import com.hotelzin.cinhospede.model.Room;
import com.hotelzin.cinhospede.model.RoomController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoomMVCController {

  @Autowired
  private RoomController roomController;

  @GetMapping("/rooms/{id}")
  @ResponseBody
  public List<Room> home(@PathVariable Long id) {
    return roomController.getAllRooms(id);
  }

  @GetMapping("/rooms/")
  public ModelAndView home() {
    ModelAndView mv = new ModelAndView("new");
    return mv;
  }
}
