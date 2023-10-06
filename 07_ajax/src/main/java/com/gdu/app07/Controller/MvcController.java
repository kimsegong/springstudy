package com.gdu.app07.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MvcController {

  @RequestMapping(value="/", method=RequestMethod.GET)
  public String index() {
    return "index";
  }
  @RequestMapping(value="/ajax1.do", method=RequestMethod.GET)
  public String ajax1() {
    return "ajax1";
  }
  @RequestMapping(value="/ajax2.do", method=RequestMethod.GET)
  public String ajax2() {
    return "ajax2";
  }
  @RequestMapping(value="/ajax3.do", method=RequestMethod.GET)
  public String ajax3() {
    return "ajax3";
  }
  @RequestMapping(value="/ajax4.do", method=RequestMethod.GET)
  public String ajax4() {
    return "ajax4";
  }
  
}