package com.hotelzin.cinhospede.controllers;

import javax.servlet.http.HttpSession;

import com.hotelzin.cinhospede.Facade;
import com.hotelzin.cinhospede.model.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @Autowired
  private Facade facade;

  @GetMapping("/")
  public ModelAndView home(HttpSession session) {
    String name = (String) session.getAttribute("name");
    ModelAndView mv = new ModelAndView("home");
    mv.addObject("name", name);
    return mv;
  }

  @PostMapping("/login")
  public ModelAndView login(String email, String password, HttpSession session) {
    Admin admin = facade.login(email, password);

    if (admin != null) {
      session.setAttribute("name", admin.getName());
      session.setAttribute("email", admin.getEmail());
      return new ModelAndView("redirect:/");
    } else {
      return new ModelAndView("redirect:/login");
    }
  }

  @GetMapping("/login")
  public ModelAndView register() {
    ModelAndView mv = new ModelAndView("admin/login");
    return mv;
  }

  @PostMapping("/logout")
  public ModelAndView logout(HttpSession session) {
    session.removeAttribute("name");
    session.removeAttribute("email");
    return new ModelAndView("redirect:/login");
  }
}
