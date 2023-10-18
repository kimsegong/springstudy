package com.gdu.app13.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app13.service.FileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class FileController {

  private final FileService fileService;
  
  @PostMapping(value="/upload.do")
  public String upload(MultipartHttpServletRequest multipartRequest, RedirectAttributes redirectAttributes) {
    int addResult = fileService.upload(multipartRequest);
    redirectAttributes.addFlashAttribute("addResult", addResult);
    return "redirect:/main.do";
  }
  @PostMapping(value="/ajax/upload.do", produces="application/json")
  @ResponseBody
  public Map<String, Object> ajaxUpload(MultipartHttpServletRequest multipartRequest) {   
    return fileService.ajaxUpload(multipartRequest);
  }
  
  @PostMapping(value = "/ckeditor/upload.do", produces="application/json")
  @ResponseBody
  public Map<String, Object> ckeditorUpload(MultipartFile upload, HttpServletRequest request) {
    return fileService.ckeditorUpload(upload, request.getContextPath());
  }
  
  @PostMapping(value="/add.do")
  public void add(@RequestParam String contents) {
    System.out.println(contents);
  }
}
