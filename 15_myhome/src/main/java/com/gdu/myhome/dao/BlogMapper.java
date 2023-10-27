package com.gdu.myhome.dao;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.myhome.dto.BlogDto;
import com.gdu.myhome.dto.BlogImageDto;

@Mapper
public interface BlogMapper {
  public int insertBlog(BlogDto blog);
  public int insertBlogImage(BlogImageDto imageDto);
}
