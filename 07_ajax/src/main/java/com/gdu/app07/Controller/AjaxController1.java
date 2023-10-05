package com.gdu.app07.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app07.Dto.AjaxDto;
import com.gdu.app07.Service.AjaxService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/ajax1")
@RequiredArgsConstructor
@Controller
public class AjaxController1 {

  private final AjaxService ajaxService;
  
  @ResponseBody  // 메서드의 반환 값이 데이터이다.
  @RequestMapping(value="/list.do", method=RequestMethod.GET, produces = "application/json; charset=UTF-8") // produces : 응답 데이터 타입
  public List<AjaxDto> list() {
    return ajaxService.getDtoList(); // jackson 라이브러리가 List<Dto1>를 json 데이터로 자동 변환한다.
  }
  
  @ResponseBody
  @RequestMapping(value="/detail.do", method=RequestMethod.GET, produces= "application/json; charset=UTF-8")
  public AjaxDto detail(@RequestParam(value="name") String name) {
    System.out.println(name);
    return ajaxService.getDto(name);
  }
}
