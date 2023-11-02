package com.gdu.myhome.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UploadService {
  public boolean addUpload(MultipartHttpServletRequest multipartRequest) throws Exception;
  public Map<String, Object> getUploadList(HttpServletRequest request);
}
