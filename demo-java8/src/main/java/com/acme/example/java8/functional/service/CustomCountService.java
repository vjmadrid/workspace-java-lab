package com.acme.example.java8.functional.service;

import java.util.List;

import com.acme.example.java8.entity.Account;

public interface CustomCountService {

	long countAllAccounts(List<Account> accountList);
	
	long countAccountsGreaterThan1(List<Account> accountList);

	long countAccountsEqualsOwner(List<Account> accountList, String owner);
	
	long defaultCount();
	
	long defaultCountStatic();
	
}
