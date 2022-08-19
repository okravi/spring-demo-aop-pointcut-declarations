package com.lc.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		
		try {
			
			TimeUnit.SECONDS.sleep(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Heavy traffic";
	}

}
