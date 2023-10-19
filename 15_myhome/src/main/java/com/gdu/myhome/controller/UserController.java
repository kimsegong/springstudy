package com.gdu.myhome.controller;

import org.springframework.stereotype.Controller;

import com.gdu.myhome.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

  private final UserService userService;
}
