package com.enjoy.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LogAspect {

    @Pointcut("within(com.enjoy.spring.dao..*)")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void befor(){
        System.out.println("===========befor pointCut=========");
    }
}
