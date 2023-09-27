package com.gdu.app03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app03.dto.BlogDto;

@Controller
public class MyController03 {

  /*
   * 1. HttpServletRequest request를 이용한 요청 파라미터 처리
   *  1) Java EE 표준 방식이다.
   *  2) 파라미터뿐만 아니라 HttpSession session, String contextPath 와 같은 정보도 꺼낼 수 있으므로 여전히 강력한 도구이다.
   */
  
  // @RequestMapping("/blog/detail.do")  // GET 방식의 method는 생략할 수 있다. value만 작성할 땐 value= 부분도 생략할 수 있다.
  public String blogDetail(HttpServletRequest request, Model model) {
    // ViewResolver의 prefix : /WEB-INF/views/
    // ViewResolver의 suffix : .jsp
    String blogNo = request.getParameter("blogNo");
    model.addAttribute("blogNo", blogNo);
    return "blog/detail";  //  /WEB-INF/views/blog/detail.jsp로 forward한다.
  }

  
  /*
   * 2. @RequestParam을 이용한 요청 파라미터 처리
   *  1) 파라미터의 개수가 적은 경우에 유용하다.
   *  2) 주요 메소드
   *    (1) value        : 요청 파라미터의 이름
   *    (2) required     : 요청 파라미터의 필수 여부(디폴트 true - 요청 파라미터가 없으면 오류 발생)
   *    (3) defaultValue : 요청 파라미터가 없는 경우에 사용할 값
   *  3) @RequestParam을 생략할 수 있다.
   */
  
  //@RequestMapping("/blog/detail.do")
  public String blogDetail2(@RequestParam(value="blogNo", required=false, defaultValue="1") int blogNo, Model model) {
    model.addAttribute("blogNo", blogNo);
    return "blog/detail";
  }
  
  /*
   * 3. 커맨드 객체를 이용한 요청 파라미터 처리
   *  1) 요청 파라미터를 필드로 가지고 있는 객체를 커맨드 객체라고 한다.
   *  2) 요청 파리머를 필드에 저장할 때 Setter가 사용된다.
   *  3) 요청 파라미터가 많은 경우에 유용하다.
   *  4) 커맨드 객체는 자동으로 Model에 저장된다. 저장될 때 객체명(dto)이 아닌 클래스명(BlogDto)으로 저장된다.(클래스명을 LowerCamelCase로 바꿔 저장한다)
   */
  
  //@RequestMapping("/blog/detail.do")
  public String blogDetail3(BlogDto dto) {  // Model에 저장된 이름은 dto가 아니라 bolgDto이다.
   // model.addAttribute("blogDto", dto);
    return "blog/detail";
  }
  
  // @ModelAttribute를 이용해서 Model를 저장되는 커맨드 객체의 이름을 지정할 수 있다.
  
  @RequestMapping("/blog/detail.do")
  public String blogDetail4(@ModelAttribute("dto") BlogDto blogDto) { // Model에 저장되는 이름을 dto 이다.
    return "blog/detail";
  }
  
  
  
  
  
}