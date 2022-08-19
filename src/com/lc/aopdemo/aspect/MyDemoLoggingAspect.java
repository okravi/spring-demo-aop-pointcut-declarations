package com.lc.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lc.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	@Before("com.lc.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n ====> Executing @Before advice");
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		//display the method args
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				
				Account theAccount = (Account) tempArg;
				
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());

			}
		}
	}
	
	@AfterReturning(
			pointcut="execution (* com.lc.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
			//print the method we're advising on
			String method = theJoinPoint.getSignature().toShortString();
			System.out.println("\n");
			System.out.println(" ====> Executing @AfterReturning advice");
			System.out.println("Advising on method: " + method);
			System.out.println("Result is: " + result);
			
			//post-process the data
			convertAccountNamesToUpperCase(result);
		
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		if (result!=null) {
			for (Account acc : result) {
				String theUpperName = acc.getName().toUpperCase();
				acc.setName(theUpperName);
			}
		}
		
	}
	
	@After("com.lc.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n ====> Executing @After Advice");
	}
	
	@Around("execution (* com.lc.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		//print out metod
		System.out.println(" ====> Executing @Around advice");
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("Advising on method: " + method);

		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		//execute method
		Object result = theProceedingJoinPoint.proceed();
		
		//get end timestamp
		long end = System.currentTimeMillis();

		//calculate duration
		System.out.println("Spent time: " + (end - begin));
		
		//return result to the caller
		return result;
		
	}
	
}
