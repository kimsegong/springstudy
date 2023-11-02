package com.gdu.movie.service;

import java.util.List;
import java.util.Map;

import com.gdu.movie.dto.MovieDto;


public interface MovieService {
  public Map<String, Object> getMovieList(); 
  public int getSearchMovieCount(Map<String, Object> map);
  public List<MovieDto> getSearchMovieList(Map<String, Object> map);
}
