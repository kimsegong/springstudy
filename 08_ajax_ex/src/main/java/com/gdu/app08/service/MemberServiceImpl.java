package com.gdu.app08.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.gdu.app08.dao.MemberDao;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor  
@Service
public class MemberServiceImpl implements MemberService {

  private final MemberDao memberDao;
  
  @Override
  public Map<String, Object> getBmiInof(int memberNo) {
 
    return null;
  }
}
