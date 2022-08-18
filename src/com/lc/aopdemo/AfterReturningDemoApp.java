package com.lc.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lc.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		//read spring config
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call business method
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		System.out.println("\n Main program: AfterReturningDemoApp");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		//close the context
		context.close();
	}

}
