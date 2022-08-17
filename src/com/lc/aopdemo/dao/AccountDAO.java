package com.lc.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.lc.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount) {
		
		System.out.println(getClass() + " Adding an account");
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + " Doing some work");
		
		return false;
	}

}
