package com.gdu.app01.xml02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {
    
    // app-context.xml 파일 읽고 <bean> 태그에 정의된 객체 생성
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml02/app-context.xml");
    
    // 객체 가져오기
    User user = ctx.getBean("user", User.class);
    Board board = ctx.getBean("board", Board.class);
    
    // 확인
    System.out.println(user.getUserNo() + "," + user.getUserId());
    System.out.println(board.getTitle() + "," + board.getEditor());
    
    //app-context.mxl
    ctx.close();
  }

}
