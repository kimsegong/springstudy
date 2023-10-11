package com.gdu.app10.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Component
@Aspect
@Slf4j
public class AroundAop {

  // 포인트컷 : 언제 동작하는가?
  @Pointcut("execution(* com.gdu.app10.controller.*Controller.*(..))")
  public void setPointCut() { }
  
  // 어드바이스 : 무슨 동작을 하는가?
  @Around("setPointCut()")
  public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    
    /*
     * Around 어드바이스
     * 1. 반환타입 : Object
     * 2. 메서드명 : 마음대로
     * 3. 매개변수 : ProceedingJoinPoint
     */
    // 로그 찍기
    log.info("======================================================");  // 포인트컷 실행 이전에 실행할 코드(@Before 이전에 동작)
    
    Object obj = proceedingJoinPoint.proceed();  // 포인트컷이 실행되는 시점
    
    log.info("{}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));   // 포인트컷 실행 이후에 실행(@After 이전에 동작)
    
    return obj;
  }
}
