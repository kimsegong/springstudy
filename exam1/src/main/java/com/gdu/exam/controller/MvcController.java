package com.gdu.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MvcController {

  @GetMapping(value="/")
  public String list() {
    return "redirect:/board/list.do";
  }
  
}