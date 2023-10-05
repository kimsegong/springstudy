package com.gdu.app06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app06.dao.BoardDao;
import com.gdu.app06.dto.BoardDto;
import com.gdu.app06.service.BoardServiceImpl;
import com.gdu.app06.service.IBoardService;

@Configuration
public class BoardConfig {

  @Bean
  public BoardDto boardDto1() {  // <bean class="BoardDto" id="boardDto1" />
    return new BoardDto(1, "제목1", "작성자1");
  }
  
  @Bean
  public BoardDto boardDto2() {  // <bean class="BoardDto" id="boardDto2" />
    return new BoardDto(2, "제목2", "작성자2");
  }
  
  @Bean
  public BoardDto boardDto3() {  // <bean class="BoardDto" id="boardDto3" />
    return new BoardDto(3, "제목3", "작성자3");
  }
  
  @Bean
  public BoardDao boardDao() {
    return new BoardDao();
  }
  
  @Bean
  public IBoardService iBoardService() {
    return new BoardServiceImpl();
  }
  
}