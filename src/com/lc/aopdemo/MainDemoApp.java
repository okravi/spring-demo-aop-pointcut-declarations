package com.lc.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lc.aopdemo.dao.AccountDAO;
import com.lc.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		//read spring config
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call business method
		Account account = new Account();
		theAccountDAO.addAccount(account);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		theMembershipDAO.addAccount();
		
		theMembershipDAO.goToSleep();
		
		//close the context
		context.close();
	}

}
