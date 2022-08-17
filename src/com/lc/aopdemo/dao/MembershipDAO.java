package com.lc.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		
		System.out.println(getClass() + " Doing stuff - adding account");
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + " Going to sleep!");
	}

}
