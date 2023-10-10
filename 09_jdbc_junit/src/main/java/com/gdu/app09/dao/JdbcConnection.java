package com.gdu.app09.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

@Component
public class JdbcConnection {

  public Connection getConnection() {
    
    Connection con = null;
    
    try {
      Class.forName("oracle.jdbc.OracleDriver");
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GD", "1111");
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
