package com.gdu.app14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MvcController {

  @GetMapping(value={"/", "/main.do"})
  public String index() {
    return "index";
  }
  
}