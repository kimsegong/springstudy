package com.gdu.app08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MvcController {

  @RequestMapping(value="/", method=RequestMethod.GET)
  public String index() {
    return "index";
  }
  
  @RequestMapping(value="/shop.go", method=RequestMethod.GET)
  public String shop() {
    return "shop";
  }
  
}
