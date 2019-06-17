package com.acme.example.java8.entity;

import java.util.List;

public class Bank {

	private List<Account> accountList;

	public Bank(List<Account> accountList) {
		super();
		this.accountList = accountList;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	
}
