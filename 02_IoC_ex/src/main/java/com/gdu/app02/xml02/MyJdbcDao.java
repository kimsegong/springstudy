package com.gdu.app02.xml02;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyJdbcDao {
  
  private Connection con;
  private AbstractApplicationContext ctx;
  private MyJdbcConnection myJdbcConnection;
  
  private Connection getConnection() {
    ctx = new GenericXmlApplicationContext("xml02/appCtx.xml");
    myJdbcConnection = ctx.getBean("myJdbcConnection", MyJdbcConnection.class);
    ctx.close();
    return myJdbcConnection.getConnection();
  }
  
  private void close() {
    try {
      if(con != null) {
        con.close();
        System.out.println(myJdbcConnection.getUser() + " 접속 해제");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void add() {
    con = getConnection();
    System.out.println("add() 호출");
    close();
  }
  
  public void remove() {
    con = getConnection();
    System.out.println("remove() 호출");
    close();
  }
  
  public void modify() {
    con = getConnection();
    System.out.println("modify() 호출");
    close();
  }
  
  public void select() {
    con = getConnection();
    System.out.println("select() 호출");
    close();
  }
  
}