package com.lc.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Account> findAccounts(){
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("John", "silver");
		Account temp2 = new Account("Luka", "silver");
		Account temp3 = new Account("Eddie", "gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}

	public void addAccount(Account theAccount) {
		
		System.out.println(getClass() + " Adding an account");
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + " Doing some work");
		
		return false;
	}

}
