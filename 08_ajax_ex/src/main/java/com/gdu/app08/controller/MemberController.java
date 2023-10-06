package com.gdu.app08.controller;

import org.springframework.stereotype.Controller;

import com.gdu.app08.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {

  private final MemberService memberService;
  
  
}
