package com.gdu.app01.anno03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  
  @Bean
  public Student student() {
    Student student = new Student();
    student.setSubjects(Arrays.asList("국어", "영어", "수학"));
    student.setContacts(new HashSet<String>(Arrays.asList("010-0000-0000", "010-9999-9999")));
    student.setFriends(Map.of("동네친구", "루피", "학교친구", "뚜비", "사회친구", "포비"));
    return student;
  }
}
