package com.gdu.app08.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

public interface ShopService {
  public ResponseEntity<String> getShoppingList(HttpServletRequest request);
}
