package com.spring.aop.learning.aop;

import com.spring.aop.learning.controller.Item;
import com.spring.aop.learning.controller.Relationship;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LogParameter {

    @Before("execution(* com.spring.aop.learning.controller.RelationshipController.saveRelationships(..)) && args(relationships)")
    public void logRequestParameter(JoinPoint joinPoint, List<Relationship> relationships){
        System.out.println(relationships);
    }

    @Before("execution(* com.spring.aop.learning.controller.RelationshipController.save(..)) && args(items)")
    public void logRequestParameter2(List<Item> items){
        System.out.println(items);
    }

    @Before("@annotation(com.spring.aop.learning.dao.Transaction) && args(items)")
    public void logRequestParameter3(JoinPoint joinPoint, List<Item> items){
        System.out.println(items);
    }

    @AfterReturning(value = "execution(* com.spring.aop.learning.dao.*.*(..))", returning = "result")
    public void saveResult(JoinPoint joinPoint, Object result){
        System.out.println(result);
    }

    @Pointcut("within(com.spring.aop.learning..*)")
    private void exception(){}

    @AfterThrowing(value = "execution(* com.spring.aop.learning..*.*(..))", throwing = "error")
    public void saveResult(JoinPoint joinPoint, IllegalArgumentException error){
        System.out.println("Failed ------------------------  " + error);
    }




}
