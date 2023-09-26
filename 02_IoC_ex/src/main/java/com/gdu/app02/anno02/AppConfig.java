package com.gdu.app02.anno02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  
  @Bean
  MyJdbcConnection myJdbcConnection() {
    MyJdbcConnection mjc = new MyJdbcConnection();
    mjc.setDriver("oracle.jdbc.OracleDriver");
    mjc.setPassword("1111");
    mjc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
    mjc.setUser("GD");
    return mjc;
  }
  @Bean
  MyJdbcDao myJdbcDao() {
    MyJdbcDao md = new MyJdbcDao();
    return md;
  }
  @Bean
  MyJdbcService myJdbcService() {
    MyJdbcService ms = new MyJdbcService();
    ms.setMyJdbcDao(myJdbcDao());
    return ms;
  }
}
