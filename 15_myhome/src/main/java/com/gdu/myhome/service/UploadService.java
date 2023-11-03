package com.gdu.myhome.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UploadService {
  public boolean addUpload(MultipartHttpServletRequest multipartRequest) throws Exception;
  public Map<String, Object> getUploadList(HttpServletRequest request);
  public void loadUpload(HttpServletRequest request, Model model);
  public ResponseEntity<Resource> download(HttpServletRequest request);
  public ResponseEntity<Resource> downloadAll(HttpServletRequest request);
  public void removeTempFiles();
}
