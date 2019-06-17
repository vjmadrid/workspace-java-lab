package com.acme.example.java8.functional.service;

import java.util.List;

import com.acme.example.java8.entity.Account;
import com.acme.example.java8.functional.CustomCountFunctionalInterface;
import com.acme.example.java8.functional.CustomCountFunctionalInterfaceImpl;

public class CustomCountServiceImpl implements CustomCountService {

	private CustomCountFunctionalInterface customCount;
	
	public CustomCountServiceImpl(){
		customCount = new CustomCountFunctionalInterfaceImpl();
	}
	
	@Override
	public long countAllAccounts(List<Account> accountList) {
		return customCount.count(accountList, n-> true);
	}

	@Override
	public long countAccountsGreaterThan1(List<Account> accountList) {
		return customCount.count (accountList, n-> n.getId() > 1 );
	}

	@Override
	public long countAccountsEqualsOwner(List<Account> accountList, String owner) {
		return customCount.count (accountList, n-> n.getOwner().equals(owner) );
	}

	@Override
	public long defaultCount() {
		return customCount.defaultCount();
	}

	@Override
	public long defaultCountStatic() {
		return CustomCountFunctionalInterface.defaultCountStatic();
	}

}
