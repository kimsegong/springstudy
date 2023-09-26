package com.gdu.app01.anno03;

import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {
    
    // AppConfig.java에 등록된 bean생성
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    
    // bean 가져오기
    Student student = ctx.getBean("student", Student.class);
    
    // 확인
    for(String subject : student.getSubjects()) {
      System.out.println(subject);
    }
    for(String contact : student.getContacts()) {
      System.out.println(contact);
    }
    for(Map.Entry<String, String> entry : student.getFriends().entrySet()) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
    
    ctx.close();
  }

}
