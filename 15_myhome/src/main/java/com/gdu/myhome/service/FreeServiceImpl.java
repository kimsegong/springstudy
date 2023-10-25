package com.gdu.myhome.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.myhome.dao.FreeMapper;
import com.gdu.myhome.dto.FreeDto;
import com.gdu.myhome.util.MyPageUtils;
import com.gdu.myhome.util.MySecurityUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FreeServiceImpl implements FreeService {

  private final FreeMapper freeMapper;
  private final MyPageUtils myPageUtils;
  private final MySecurityUtils mysecurityUtils;
  
  @Override
  public int addFree(HttpServletRequest request) {
    
    String email = request.getParameter("email");
    String contents = mysecurityUtils.preventXSS(request.getParameter("contents"));
    
    FreeDto free = FreeDto.builder()
                     .email(email)
                     .contents(contents)
                     .build();
    return freeMapper.insertFree(free);
  }
  
  @Override
  public void loadFreeList(HttpServletRequest request, Model model) {
    
    Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
    int page = Integer.parseInt(opt.orElse("1"));
    
    int display = 10;
    
    int total = freeMapper.getFreeCount();
    
    myPageUtils.setPaging(page, total, display);
    
    Map<String, Object> map = Map.of("begin", myPageUtils.getBegin()
                                   , "end", myPageUtils.getEnd());
    
    List<FreeDto> freeList = freeMapper.getFreeList(map);
    
    model.addAttribute("freeList", freeList);
    model.addAttribute("paging", myPageUtils.getMvcPaging(request.getContextPath() + "/free/list.do"));
    model.addAttribute("beginNo", total - (page - 1) * display);
  }
}
