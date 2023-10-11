package com.gdu.app10.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
public class AfterAop {

  // 포인트컷 : 언제 동작하는가?
  @Pointcut("execution(* com.gdu.app10.controller.*Controller.*(..))")
  public void setPointCut() { }
  
  // 어드바이스 : 무슨 동작을 하는가?
  @After("setPointCut()")
  public void afterAdvice(JoinPoint joinPoint) {
    
    /*
     * After 어드바이스
     * 1. 반환타입 : void
     * 2. 메서드명 : 마음대로
     * 3. 매개변수 : JoinPoint
     */
    
    // 로그 찍기
    log.info("======================================================");
    
  }
}
