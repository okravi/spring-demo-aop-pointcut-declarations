package com.lc.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution (* com.lc.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution (* com.lc.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution (* com.lc.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ====> Executing @Before advice");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		
		System.out.println("\n ====> Executing @Before advice - API analytics");
	}
}
