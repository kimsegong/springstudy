package com.gdu.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.app.dto.NoticeDto;
import com.gdu.app.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeController {

  private final NoticeService noticeService;
  
  @GetMapping(value="/notice/list.do")  
  public String list(Model model) { // forward할 데이터는 Model에 저장한다.
    List<NoticeDto> noticeList = noticeService.getNoticeList();
    model.addAttribute("noticeList", noticeList);  // forward할 데이터 저장하기(저장한 이름은 noticeList)
    return "notice/list"; // notice 폴더 아래의 list.jsp로 forward하시오.
  }
  @GetMapping(value="/notice/write.do")
  public String write() {
    return "notice/write";
  }
}
