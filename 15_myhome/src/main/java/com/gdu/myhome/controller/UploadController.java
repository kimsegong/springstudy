package com.gdu.myhome.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.myhome.service.UploadService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/upload")
@RequiredArgsConstructor
@Controller
public class UploadController {

  private final UploadService uploadService;
  
  @GetMapping("/list.do")
  public String list() {
    return "upload/list";
  }
  
  @GetMapping("/write.form")
  public String write() {
    return "upload/write";
  }
  
  @PostMapping("/add.do")
  public String add(MultipartHttpServletRequest multipartRequest
                  , RedirectAttributes redirectAttributes) throws Exception {
    boolean addResult = uploadService.addUpload(multipartRequest);
    redirectAttributes.addFlashAttribute("addResult", addResult);
    return "redirect:/upload/list.do";
  }
  
  @ResponseBody
  @GetMapping(value="/getList.do", produces="application/json")
  public Map<String, Object> getList(HttpServletRequest request){
    return uploadService.getUploadList(request);
  }
  
  @GetMapping("/detail.do")
  public String detail(HttpServletRequest request, Model model) {
    uploadService.loadUpload(request, model);
    return "upload/detail";
  }
 
  @GetMapping("/download.do")
  public ResponseEntity<Resource> download(HttpServletRequest request) {
    return uploadService.download(request);
  }
  
  @GetMapping("/downloadAll.do")
  public ResponseEntity<Resource> downloadAll (HttpServletRequest request){
    return uploadService.downloadAll(request);
  }
  
  
  
  
  
  
  
}