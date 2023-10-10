package com.gdu.app09.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

@Component
public class JdbcConnection {

  /*
   * 일반 버전
   * Class.forName("oracle.jdbc.OracleDriver");
   * url = "jdbc:oracle:thin:@localhost:1521:xe"
   * 
   * 쿼리 출력 버전(log4jdbc 디펜던시)
   * Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
   * url = "jdbc:log4jdbc:oracle:thin:@localhost:1521:xe"
   */
  
  public Connection getConnection() {
    
    Connection con = null;
    
    try {
      Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
      con = DriverManager.getConnection("jdbc:log4jdbc:oracle:thin:@localhost:1521:xe", "GD", "1111");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }
  
  public void close(Connection con, PreparedStatement ps, ResultSet rs) {
    try {
      if(rs != null) rs.close();
      if(ps != null) ps.close();
      if(con != null) con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
