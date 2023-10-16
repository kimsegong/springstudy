package com.gdu.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app.dto.NoticeDto;
import com.gdu.app.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeController {

  private final NoticeService noticeService;
  
  @RequestMapping(value="/notice/list.do", method=RequestMethod.GET)
  public String list(Model model) {  // forward할 데이터는 Model에 저장한다.
    List<NoticeDto> noticeList = noticeService.getNoticeList();
    model.addAttribute("noticeList", noticeList);  // forward할 데이터 저장하기(저장한 이름은 noticeList)
    return "notice/list";  // notice 폴더 아래의 list.jsp로 forward하시오.
  }
  
  @RequestMapping(value="/notice/write.do", method=RequestMethod.GET)
  public String write() {
    return "notice/write";
  }
  
  @RequestMapping(value="/notice/save.do", method=RequestMethod.POST)
  public String save(NoticeDto noticeDto, RedirectAttributes redirectAttributes) {  // redirect할 데이터는 RedirectAttributes에 저장한다.
    int addResult = noticeService.addNotice(noticeDto);
    redirectAttributes.addFlashAttribute("addResult", addResult);
    return "redirect:/notice/list.do";
  }
  
  @RequestMapping(value="/notice/detail.do", method=RequestMethod.GET)
  public String detail(@RequestParam int noticeNo, Model model) {
    NoticeDto noticeDto = noticeService.getNotice(noticeNo);
    model.addAttribute("notice", noticeDto);
    return "notice/detail";  // notice 폴더 아래 detail.jsp로 notice를 보낸다.
  }
  
  @RequestMapping(value="/notice/modify.do", method=RequestMethod.POST)
  public String modify(NoticeDto noticeDto, RedirectAttributes redirectAttributes) {
    int modifyResult = noticeService.modifyNotice(noticeDto);
    redirectAttributes.addFlashAttribute("modifyResult", modifyResult);
    return "redirect:/notice/detail.do?noticeNo=" + noticeDto.getNoticeNo();
  }
  
  
  
  
  
  
  
  
  
}