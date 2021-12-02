package com.infinitelambda.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @Before("execution(* com.infinitelambda.demo.service.impl.EmployeeServiceImpl.findAllEmployee())")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before ");
        System.out.println(joinPoint.getSignature().getName());
    }

//    @AfterReturning(pointcut = "execution(*")
//    public void afterReturning(JoinPoint joinPoint, Object result) {
//        System.out.println(joinPoint.getSignature().getName()
//            + " Returned with " + result);
//    }
}
