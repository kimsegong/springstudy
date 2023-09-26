package com.gdu.app02.anno01;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  
  @Bean
  public Calculator calc() {
    return new Calculator();
  }
  
  // Member
  @Bean
  public Member member() {
    Member member = new Member();
    member.setCalculator(calc());
    member.setHeight(158);
    member.setName("콩이");
    member.setStatus(null);
    member.setWeight(5);
    double w = member.getWeight();
    double h = member.getHeight();
    Calculator c = member.getCalculator();
    member.setBmi( c.div (w, c.div(c.mul(h, h), 10000)));
    double bmi = member.getBmi();
    member.setStatus(bmi < 20 ? "저체중" : bmi < 25 ? "정상" : bmi < 30 ? "과제중" : "비만");
    return member;
  }
  
  // Fitness
  @Bean
  public Fitness fitness() {
    Fitness fitness = new Fitness();
    fitness.setName("콩이피트니스");
    fitness.setMembers(Arrays.asList(member()));
    
    return fitness;  
  }
  
  
  
  
  
}
