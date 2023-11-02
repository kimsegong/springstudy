package com.gdu.movie.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gdu.movie.dao.MovieMapper;
import com.gdu.movie.dto.MovieDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

  private final MovieMapper movieMapper;
  
  @Override
  public Map<String, Object> getMovieList() {
    
    int movieCount = movieMapper.getMovieCount();
    List<MovieDto> list = movieMapper.getMovieList();
    
    return Map.of("message", "전체" + movieCount + "개의 목록을 가져왔습니다."
                 , "list", list
                 , "status", 200);
    
  }
  @Override
  public int getSearchMovieCount(Map<String, Object> map) {
    return movieMapper.getSearchMovieCount(map);
  }

  @Override
  public List<MovieDto> getSearchMovieList(Map<String, Object> map) {
    return movieMapper.getSearchMovieList(map);
  }
}
