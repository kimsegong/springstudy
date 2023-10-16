package com.gdu.app14.service;


import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.gdu.app14.dto.MemberDto;

public interface MemberService {

  // 회원 등록
  public Map<String, Object> register(MemberDto memberDto, HttpServletResponse response); 
  
  // 회원 목록 
  public Map<String, Object> getMembers(int page);
  
  
}
