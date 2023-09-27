package com.gdu.app03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller   // 컨트롤러를 만드는 Annotation
public class MyController01 {

  /*
  요청/응답을 처리할 메서드를 만든다.
  1. 반환 타입
    1) String : 응답할 Jsp의 이름을 반환한다.
    2) void   : 컨트롤러가 호출한 서비스에서 직접 반환한다.
    3) 기타   : 비동기 통신에서 데이터를 응답한다.
  2. 메서드명
    - 아무 일도 안 한다.
  3. 매개변수
    1) HttpServletRequest를 선언해서 사용할 수 있다.
    2) HttpServletResponse를 선언해서 사용할 수 있다.
    3) Model를 선언해서 forward할 정보를 저장할 수 있다.
  4. 요청
    1) 메서드 : GET, POST
    2) URL    : 요청 주소
  */
  
    // value="/"         : contextPath 요청을 의미한다. http://localhost/app03/ 주소를 의미한다.
    // value="/main.do"  : /main.do 요청을 의미한다.    http://localhost/app03/main.do 주소를 의미한다.
  
  @RequestMapping(value={"/", "/main.do"}, method=RequestMethod.GET)
  public String welcome() {
    // ViewResolver의 prefix : /WEB-INF/views/
    // ViewResolver의 suffix : .jsp
    return "index";
  }
  
  @RequestMapping(value="/board/list.do", method=RequestMethod.GET)
  public String boardList() {
    // ViewResolver의 prefix : /WEB-INF/views/
    // ViewResolver의 suffix : .jsp
    return "board/list";  
  }
}
