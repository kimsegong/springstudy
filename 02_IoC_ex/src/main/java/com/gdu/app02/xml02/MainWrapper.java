package com.gdu.app02.xml02;

import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml02/appCtx.xml");
    MyJdbcService myJdbcService = ctx.getBean("service", MyJdbcService.class);
    myJdbcService.add();
    myJdbcService.modify();
    myJdbcService.remove();
    myJdbcService.select();
    
    ctx.close();
  }
}
