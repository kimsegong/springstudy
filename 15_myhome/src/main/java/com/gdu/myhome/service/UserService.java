package com.gdu.myhome.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

public interface UserService {
  public void login(HttpServletRequest request, HttpServletResponse response);
  public void logout(HttpServletRequest request, HttpServletResponse response);
  public ResponseEntity<Map<String, Object>> checkEmail(String email);
  public ResponseEntity<Map<String, Object>> sendCode(String email);
  public void join(HttpServletRequest request, HttpServletResponse response);
  public ResponseEntity<Map<String, Object>> modify(HttpServletRequest request);
  public void modifyPw(HttpServletRequest request, HttpServletResponse response);
  public void leave(HttpServletRequest request, HttpServletResponse response);
  public ResponseEntity<Map<String, Object>> selectId(HttpServletRequest request, HttpServletResponse response);
}
