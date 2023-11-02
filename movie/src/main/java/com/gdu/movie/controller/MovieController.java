package com.gdu.movie.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.movie.dto.MovieDto;
import com.gdu.movie.service.MovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MovieController {

  private final MovieService movieService;
  
  @GetMapping(value="/searchAllMovies", produces = "application/json")
  public Map<String, Object> searchAllMovies() {       
    return movieService.getMovieList();
  }
  
  @GetMapping(value="/searchMovies", produces = "application/json")
  public Map<String, Object> searchMovies(@RequestParam("column") String column, @RequestParam("searchText") String searchText) {
    int count = movieService.getSearchMovieCount(Map.of("column", column, "query", searchText));
    List<MovieDto> list = movieService.getSearchMovieList(Map.of("column", column, "query", searchText));
    return Map.of("message", "검색 결과: " + count + "개의 목록을 가져왔습니다.", "list", list, "status", 200);
  }


  
  
}
