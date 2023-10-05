package com.gdu.app07.Controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.app07.Dto.AjaxDto;
import com.gdu.app07.Service.AjaxService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/ajax2")
@RestController // 모든 메서드에 @ResponseBody를 추가하는 @Controller이다.
@RequiredArgsConstructor
public class AjaxController2 {

  private final AjaxService ajaxService;
  
  @GetMapping(value="/list.do", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<AjaxDto> getDtoList() {
    return ajaxService.getDtoList();
  }
  @GetMapping(value="/detail.do", produces = MediaType.APPLICATION_JSON_VALUE)
  public AjaxDto getDto(@RequestParam(value="name") String name) {
    return ajaxService.getDto(name);
  }
}
