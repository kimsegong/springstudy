package com.gdu.app01.xml03;



import java.util.Map.Entry;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {
   
    // app-context.xml에 정의된 <bean> 태그를 객체로 생성
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml03/app-context.xml");
    
    // 객체 가져오기
    Student s = ctx.getBean("student", Student.class);
    
    // 확인
    for(String subject: s.getSubjects()) {
      System.out.println(subject);
    }
    for(String contact : s.getContacts()) {
      System.out.println(contact);
    } 
    for(Entry<String, String> entry : s.getFriends().entrySet()) {
      System.out.println(entry.getKey() + "," + entry.getValue());
    }
    
    ctx.close();
  }

}
