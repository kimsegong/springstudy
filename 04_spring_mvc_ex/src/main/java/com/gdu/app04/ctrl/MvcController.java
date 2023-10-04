package com.gdu.app04.ctrl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app04.vo.ArticleVo;

@Controller
public class MvcController {

  // DispatcherServlet(servlet-context.xml)에서 ViewResolver를 제거했으므로 JSP의 전체 경로를 모두 작성해야 한다.
  
  @RequestMapping(value="/", method=RequestMethod.GET)
  public String main() {
    return "/WEB-INF/main.jsp";
  }
  
  @RequestMapping(value="/write.do", method=RequestMethod.GET)
  public String write() {
    return "/WEB-INF/article/write.jsp";
  }
  
  // @RequestMapping(value="/register.do", method=RequestMethod.POST)
  public String register(HttpServletRequest request, Model model) {
    int articleNo = Integer.parseInt(request.getParameter("articleNo"));
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    model.addAttribute("articleNo", articleNo);
    model.addAttribute("title", title);
    model.addAttribute("content", content);
    return "/WEB-INF/article/result.jsp";
  }
  
  //@RequestMapping(value="/register.do", method=RequestMethod.POST)
  public String register2(@RequestParam(value="articleNo") int articleNo
                         ,@RequestParam(value="title") String title
                         ,@RequestParam(value="content") String content
                         , Model model) {
    ArticleVo vo = new ArticleVo(articleNo, title, content);
    model.addAttribute("vo", vo);
    return "/WEB-INF/article/result.jsp";
  }
  
  //@RequestMapping(value="/register.do", method=RequestMethod.POST)
  public String register3(ArticleVo vo) {
    return "/WEB-INF/article/result.jsp";
  }
  
  @RequestMapping(value="/register.do", method=RequestMethod.POST)
  public String register4(@ModelAttribute(value="atcVo") ArticleVo vo) {
    return "/WEB-INF/article/result.jsp";
  }
  
}
