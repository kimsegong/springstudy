package com.gdu.myhome.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BlogService {
  public Map<String, Object> imageUpload(MultipartHttpServletRequest multipartRequest);
  public int addBlog(HttpServletRequest request);
}
