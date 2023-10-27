package com.gdu.myhome.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.myhome.service.BlogService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/blog")
@Controller
public class BlogController {

  private final BlogService blogService;
  
  @GetMapping("/list.do")
  public String list(HttpServletRequest request, Model model) {
    return "blog/list";
  }
  
  @GetMapping("/write.form")
  public String write() {
    return "blog/write";
  }
  
  @PostMapping(value ="/imageUpload.do", produces = "application/json")
  @ResponseBody
  public Map<String, Object> imageUpload(MultipartHttpServletRequest multipartRequest){
    return blogService.imageUpload(multipartRequest);
  }
  
  @PostMapping("/addBlog.do")
  public String addBlog(HttpServletRequest request, RedirectAttributes redirectAttributes) {
    int addResult = blogService.addBlog(request);
    redirectAttributes.addFlashAttribute("addResult", addResult);
    return "redirect:/blog/list.do";
  }
}
