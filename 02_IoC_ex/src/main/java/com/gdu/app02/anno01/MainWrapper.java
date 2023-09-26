package com.gdu.app02.anno01;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {
    
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    
   
    Fitness fitness = ctx.getBean("fitness", Fitness.class);
    
    
    System.out.println(fitness.getName());
    fitness.info();
    
    ctx.close();
  }
}
