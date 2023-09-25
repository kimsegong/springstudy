package com.gdu.app02.xml02;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyJdbcConnection {

  private String driver;    // oracle.jdbc.OracleDriver
  private String url;       // jdbc:oracle:thin:@127.0.0.1:1521:xe
  private String user;      // GD
  private String password;  // 1111
  
  public Connection getConnection() {
    
    Connection con = null;
    
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, user, password);
      System.out.println(user + "접속성공");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }
}
