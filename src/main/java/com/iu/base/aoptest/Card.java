package com.iu.base.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class Card {
	
	//@Before("execution(* com.iu.base.aoptest.Transport.use*())")
	//@AfterReturning("execution(* com.iu.base.aoptest.Transport.use*())")
	//@Around("execution(* com.iu.base.aoptest.Transport.use*(..))")
	//@AfterThrowing("execution(* com.iu.base.*.*Service.set*(..))") // rollback 
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		log.error("삐비빅 승차 입니다");
		
		Object [] objs =joinPoint.getArgs();
		
		for(Object ob : objs) {
			log.warn("ARGS =======> {}",ob.toString());
		}
		
		Object obj = joinPoint.proceed();
		log.error("삐비빅 하차!!!!!!!");
		log.warn("Object =====> {}",obj.toString());
	
	return obj;
	}
}
