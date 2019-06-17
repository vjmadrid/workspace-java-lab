package com.acme.example.java8.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.example.java8.entity.Account;

public final class AccountDataFactory {
	
	public static final long TEST_COUNT_1_ID = 1L;
	public static final String TEST_COUNT_1_OWNER = "Test Owner 1";
	public static final double TEST_COUNT_1_BALANCE = 100.0;
	
	public static final long TEST_COUNT_2_ID = 2L;
	public static final String TEST_COUNT_2_OWNER = "Test Owner 2";
	public static final double TEST_COUNT_2_BALANCE = 200.0;
	
	public static final long TEST_COUNT_3_ID = 2L;
	public static final String TEST_COUNT_3_OWNER = "Test Owner 3";
	public static final double TEST_COUNT_3_BALANCE = 300.0;
	
	
	public static Account createSampleAccountWithId(long id) {
		final Account account = new Account();
		account.setId(id);
		account.setOwner("Test Owner");
		account.setBalance(100.0);
		return account;
	}
	
	public static Account createSampleAccountWithId(long id, String owner, double balance) {
		final Account account = new Account();
		account.setId(id);
		account.setOwner(owner);
		account.setBalance(balance);
		account.setLocked(Boolean.FALSE);
		account.setCreationDate(new Date());
		account.setAccessDate(null);
		account.setLockedDate(null);
		return account;
	}
	
	public static List<Account> createSampleAccountListWithId(long id) {
		final List<Account> list = new ArrayList<Account>();
		list.add(createSampleAccountWithId(id));
		return list;
	}
	
	public static List<Account> createSampleAccountList() {
		final List<Account> list = new ArrayList<Account>();
		list.add(AccountDataFactory.createSampleAccountWithId(TEST_COUNT_1_ID, TEST_COUNT_1_OWNER, TEST_COUNT_1_BALANCE));
		list.add(AccountDataFactory.createSampleAccountWithId(TEST_COUNT_2_ID, TEST_COUNT_2_OWNER, TEST_COUNT_2_BALANCE));
		list.add(AccountDataFactory.createSampleAccountWithId(TEST_COUNT_3_ID, TEST_COUNT_3_OWNER, TEST_COUNT_3_BALANCE));
		return list;
	}
	
	public static Map<Long,Account> createSampleAccountMapWithId(long id) {
		final Map<Long,Account> accountsMap = new HashMap<>(); 
		accountsMap.put(id, createSampleAccountWithId(id));
		id++;
		accountsMap.put(id, createSampleAccountWithId(id));
		return accountsMap;
	}

}
