package com.gdu.myhome.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.myhome.dto.BlogDto;

public interface BlogService {
  public Map<String, Object> imageUpload(MultipartHttpServletRequest multipartRequest);
  public int addBlog(HttpServletRequest request);
  public void blogImageBatch();
  public void loadBlogList(HttpServletRequest request, Model model);
  public int increseHit(int blogNo);
  public BlogDto getBlog(int blogNo);
  
  public Map<String, Object> addComment(HttpServletRequest request);
  public Map<String , Object> loadCommentList(HttpServletRequest request);
}