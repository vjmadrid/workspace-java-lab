package com.acme.example.java8.streams;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.java8.entity.Account;
import com.acme.example.java8.factory.AccountDataFactory;

public class ExampleStreamsTester {

	private List<Account> accountListTest;
	
	@Before
	public final void setUp() throws Exception {
		accountListTest = AccountDataFactory.createSampleAccountList();
	}
	
	@Test
    public final void shouldCountAllAccounts() {
		long countAllAccounts = accountListTest.stream().count();
		assertEquals(3, countAllAccounts);
	}
	
	@Test
    public final void shouldCountAccountsGreaterThan1() {
		long countAccountsGreaterThan1 = accountListTest.stream().filter(account -> account.getId() > 1).count();
		assertEquals(2, countAccountsGreaterThan1);
	}
	
	@Test
    public final void shouldCountAccountsEqualsOwner() {
		long countAccountsEqualsOwner = accountListTest.parallelStream().filter(account -> account.getOwner().equals(AccountDataFactory.TEST_COUNT_2_OWNER)).count();
		assertEquals(1, countAccountsEqualsOwner);
	}
	
	@Test
    public final void shouldCountAccountsGreaterThan1List() {
		List<Account> listAccountsGreaterThan1 = accountListTest.stream().filter(account -> account.getId() > 1).collect(Collectors.toList());
		assertEquals(2, listAccountsGreaterThan1.size());
	}
	
	@Test
    public final void shouldCountAccountsGreaterThan1ListLocked() {
		List<Account> listAccountsGreaterThan1Locked = accountListTest.stream().filter(account -> account.getId() > 1).map(account -> { 
			account.setLocked(true);
			account.setLockedDate(new Date());
			return account;
		}).collect(Collectors.toList());
		
		assertEquals(2, listAccountsGreaterThan1Locked.size());
		
		assertTrue(listAccountsGreaterThan1Locked.get(0).isLocked());
		assertNotNull(listAccountsGreaterThan1Locked.get(0).getLockedDate());
		
	}

}
