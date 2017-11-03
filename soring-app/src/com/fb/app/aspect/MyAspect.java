package com.fb.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

@Pointcut("execution(* com.fb.app.dao.EmployeeJpaDao.getAllEmployees*(..))")
public void pointcutName(){}

@Before("pointcutName()")
public void myAdvice(JoinPoint jp)
{
	System.out.println("Aspect is succsfully loaded");

}

}
