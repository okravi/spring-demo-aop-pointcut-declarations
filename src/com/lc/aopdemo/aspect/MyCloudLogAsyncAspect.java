package com.lc.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAsyncAspect {
	
	@Before("com.lc.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloud() {
		
		System.out.println("\n ====> Executing @Before advice - Log to cloud");
	}
}
