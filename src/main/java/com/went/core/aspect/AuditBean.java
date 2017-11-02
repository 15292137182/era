package com.went.core.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Went
 */
@Component
@Aspect
public class AuditBean {

  @Around("within(com.went.core.service..*)")
  public Object log(ProceedingJoinPoint point) throws Throwable {
    Object obj;
    try {
      System.out.println("方法执行前*************************************************************");
      long startTime = System.currentTimeMillis();
      obj = point.proceed();
      long endTime = System.currentTimeMillis();
      String str = point.getSignature().toString();
      System.out.println("方法执行结束***********************************************************");
      System.out.println(str + "耗时:" + (endTime - startTime));
    } catch (Throwable e) {
      e.printStackTrace();
      throw e;
    }
    return obj;
  }
}








