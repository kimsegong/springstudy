package com.gdu.app08.dao;

import org.springframework.stereotype.Repository;

import com.gdu.app08.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberDao {

  private MemberDto member1;
  private MemberDto member2;
  private MemberDto member3;
  
  public MemberDto getMemberByNo(int memberNo) {
    MemberDto member = null;
    if(memberNo == member1.getMemberNo()) {
      member = member1;
    } else if(memberNo == member2.getMemberNo()) {
      member = member2;
    } else if(memberNo == member3.getMemberNo()) {
      member = member3;
    }
    return member;
  }
}
