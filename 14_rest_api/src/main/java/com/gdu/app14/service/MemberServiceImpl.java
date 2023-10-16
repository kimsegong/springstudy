package com.gdu.app14.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.gdu.app14.dao.MemberMapper;
import com.gdu.app14.dto.MemberDto;
import com.gdu.app14.util.PageUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

  private final MemberMapper memberMapper;
  private final PageUtil pageUtil;
  
  @Override
  public Map<String, Object> register(MemberDto memberDto, HttpServletResponse response) {
   
    Map<String, Object> map = null;
    
    try {
      
      int addResult = memberMapper.insertMember(memberDto);
      map = Map.of("addResult", addResult); 
      
    } catch (Exception e) {
      System.out.println(e.getClass().getName()); // 발생한 예외 클래스 이름 확인
      e.printStackTrace();
    }
    
    return map;
  }
  
  @Override
  public Map<String, Object> getMembers(int page) {

    int total = memberMapper.getMemberCount();
    int display = 2;
    
    pageUtil.setPaging(page, total, display);
    
    Map<String, Object> map = Map.of("begin", pageUtil.getBegin()
                                   , "end", pageUtil.getEnd());
    List<MemberDto> memberList = memberMapper.getMemberList(map);
    String paging = pageUtil.getAjaxPaging();
    return Map.of("memberList", memberList
                , "paging", paging);
  }
}
