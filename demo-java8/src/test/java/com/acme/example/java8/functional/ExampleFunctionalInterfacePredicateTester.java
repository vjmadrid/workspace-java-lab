package com.acme.example.java8.functional;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.java8.entity.Account;
import com.acme.example.java8.factory.AccountDataFactory;
import com.acme.example.java8.functional.service.CustomCountService;
import com.acme.example.java8.functional.service.CustomCountServiceImpl;

public class ExampleFunctionalInterfacePredicateTester {
	
	private List<Account> accountListTest;
	
	private CustomCountService customCountService;
	
	@Before
	public final void setUp() throws Exception {
		accountListTest = AccountDataFactory.createSampleAccountList();
		customCountService = new CustomCountServiceImpl();
	}
	
	@Test
    public final void shouldCountAllAccounts() {
		assertEquals(3, customCountService.countAllAccounts(accountListTest));
	}
	
	@Test
    public final void shouldCountAccountsGreaterThan1() {
		assertEquals(2, customCountService.countAccountsGreaterThan1(accountListTest));
	}
	
	@Test
    public final void shouldCountAccountsEqualsOwner() {
		assertEquals(1, customCountService.countAccountsEqualsOwner(accountListTest,AccountDataFactory.TEST_COUNT_2_OWNER));
	}

}
