package com.gdu.myhome.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.myhome.dto.BlogDto;
import com.gdu.myhome.dto.BlogImageDto;
import com.gdu.myhome.dto.CommentDto;

@Mapper
public interface BlogMapper {
  public int insertBlog(BlogDto blog);
  public int insertBlogImage(BlogImageDto imageDto);
  public List<BlogImageDto> getBlogImageInYesterday();
  public int getBlogCount();
  public List<BlogDto> getBlogList(Map<String, Object> map);
  public int updateHit(int blogNo);
  public BlogDto getBlog(int blogNo);
  
  public int insertComment(CommentDto comment);
  public int getCommentCount(int blogNo);
  public List<CommentDto> getCommentList(Map<String, Object> map);
}
