package com.lc.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.lc.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		System.out.println(getClass() + " AccountDAO - setting name");

		this.name = name;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount) {
		
		System.out.println(getClass() + " Adding an account");
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + " Doing some work");
		
		return false;
	}

}
