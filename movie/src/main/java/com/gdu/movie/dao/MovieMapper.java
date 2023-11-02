package com.gdu.movie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.movie.dto.MovieDto;

@Mapper
public interface MovieMapper {
  public int getMovieCount();
  public List<MovieDto> getMovieList();
  public int getSearchMovieCount(Map<String, Object> map);
  public List<MovieDto> getSearchMovieList(Map<String, Object> map);
}
