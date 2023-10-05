package com.gdu.app06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app06.dto.BoardDto;

@Configuration
public class BoardConfig {

  @Bean
  public BoardDto boardDto1() {
    return new BoardDto(1, "제목1", "작성자1");
  }
  @Bean
  public BoardDto boardDto2() {
    return new BoardDto(2, "제목2", "작성자2");
  }
  @Bean
  public BoardDto boardDto3() {
    return new BoardDto(3, "제목3", "작성자3");
  }
}
