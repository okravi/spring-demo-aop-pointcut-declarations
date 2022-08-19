package com.lc.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lc.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		//read spring config
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from container
		TrafficFortuneService  theTrafficFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain program: calling getFortune()");
		
		System.out.println(theTrafficFortuneService.getFortune());
		
		System.out.println("Finished");
		
		//close the context
		context.close();
	}

}
