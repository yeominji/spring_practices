package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))")
	public void beforeAdvice() {
		System.out.println("---Before Advice---");
	}

	@After("execution(* *..*.service.ProductService.*(..))")
	public void afterAdvice() {
		System.out.println("---After Advice---");
	}

	@AfterReturning("execution(* *..*.ProductService.*(..))")
	public void afterReturingAdvice() {
		System.out.println("---After Returning Advice---");
	}

	@AfterThrowing(value="execution(* *..*.*.*(..))", throwing="ex")
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("---After Throwing Advice:" + ex + "---");
	}
	@Around("execution(* *..*.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		// Before Advice
		System.out.println("@Around(Before) Advice");

		// PointCut Method 실행

		// 파라미터 가로채기(바꿔버리기)
		// Object[] params = {"Camera"};
		// Object result = pjp.proceed(params);

		Object result = pjp.proceed();

		// After Advice
		System.out.println("@Around(After) Advice");

		return result;
	}
}