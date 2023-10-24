package com.gdu.app08.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app08.service.ShopService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ShopController {

  private final ShopService shopService;
  
  @ResponseBody
  @GetMapping(value="/openapi/shopping.do", produces="application/json; charset=UTF-8")
  public ResponseEntity<String> search(HttpServletRequest request) {
    return shopService.getShoppingList(request);
  }
  
}
