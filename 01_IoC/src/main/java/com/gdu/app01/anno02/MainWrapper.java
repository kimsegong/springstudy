package com.gdu.app01.anno02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {
    
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

    User user = ctx.getBean("user", User.class);
    Board board = ctx.getBean("board", Board.class);
    
    System.out.println(user.getUserId() + "," + user.getUserNo());
    System.out.println(board.getTitle() + "," + board.getEditor());
    
    ctx.close();
    
  }

}
