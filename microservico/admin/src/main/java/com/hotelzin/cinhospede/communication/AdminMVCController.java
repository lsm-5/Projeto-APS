package com.hotelzin.cinhospede.communication;

import com.hotelzin.cinhospede.model.Admin;
import com.hotelzin.cinhospede.model.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminMVCController {

  @Autowired
  private AdminController adminController;

  @GetMapping("/{email}/{password}/admin")
  @ResponseBody
  public Admin home(@PathVariable String email, @PathVariable String password) {
    return adminController.findByEmailAndPassword(email, password);
  }

  @GetMapping("/")
  public ModelAndView home() {
    ModelAndView mv = new ModelAndView("new");
    return mv;
  }

}
