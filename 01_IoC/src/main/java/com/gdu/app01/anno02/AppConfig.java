package com.gdu.app01.anno02;

import org.springframework.context.annotation.Bean;

public class AppConfig {
  
  // @Bean에 name 속성으로 bean 이름을 등록할 수 있다.
  
  @Bean(name="user")
  public User zxdsad() {  // name="user"로 인해서 메서드이름은 의미가 없어진다.
    User user = new User();
    user.setUserId("admin");
    user.setUserNo(1);
    return user;
  }
  @Bean(name="board")
  public Board bosd() {
    Board board = new Board();
    board.setEditor(zxdsad());
    board.setTitle("맘마");
    return board;
  }
}
