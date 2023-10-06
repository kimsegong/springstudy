package com.gdu.app07.Controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gdu.app07.Dto.AjaxDto;
import com.gdu.app07.Service.AjaxService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AjaxController3 {

  private final AjaxService ajaxService;
  
  // ResponseBody가 포함되어있는 ResponseEntity 그래서 생략가능
  @GetMapping(value="/ajax3/list.do", produces = "application/json; charset=UTF-8")
  public ResponseEntity<List<AjaxDto>> list() { 
    return new ResponseEntity<List<AjaxDto>>( // ResponseEntity는 @ResponseBody를 작성하지 않는다.
                  ajaxService.getDtoList()    // 실제 응답 데이터
                , HttpStatus.OK);             // 응답 코드 (200)
  }
  
  @PostMapping(value="/ajax3/detail.do", produces="application/json; charset=UTF-8")
  public ResponseEntity<AjaxDto> detail(@RequestBody AjaxDto ajaxDto) { // post방식(@RequestBody)으로 전송된 JSON 데이터(AjaxDto ajaxDto)
    // 응답 헤더 : Content-Type 
    HttpHeaders header = new HttpHeaders();
    header.add("Content-Type", "application/json; charset=UTF-8");
    // 반환
    return new ResponseEntity<AjaxDto>(
                ajaxService.getDto(ajaxDto.getName())                         // 실제 응답 데이터
              , header                                                        // 응답 헤더
              , HttpStatus.OK);                                               // 응답 코드(200)
  }
  
}
