package com.gdu.app14.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app14.dto.MemberDto;

@Mapper
public interface MemberMapper {

  // 삽입
  public int insertMember(MemberDto memberDto); 
  
  // 목록
  public List<MemberDto> getMemberList(Map<String, Object> map);
  
  // 전체 개수
  public int getMemberCount();
}
