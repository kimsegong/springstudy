package com.gdu.app02.anno02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {
    
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    
    MyJdbcService myJdbcService = ctx.getBean("myJdbcService", MyJdbcService.class);
    
    myJdbcService.add();
    myJdbcService.modify();
    myJdbcService.remove();
    myJdbcService.select();
    
    ctx.close();

  }

}
