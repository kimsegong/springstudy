package com.gdu.myhome.service;


import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UploadService {
  public boolean addUpload(MultipartHttpServletRequest multipartRequest) throws Exception;
}
