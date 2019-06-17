package com.acme.example.java8.lambda;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.java8.entity.Account;
import com.acme.example.java8.factory.AccountDataFactory;
import com.acme.example.java8.lambda.SortLambdaUtil;

public class ExampleSortLambdaUtilTester {
	
	private List<Account> accountListTest;
	
	@Before
	public final void setUp() throws Exception {
		accountListTest = AccountDataFactory.createSampleAccountList();
	}
	
	@Test
    public final void shouldSortUsingJava7() {
		SortLambdaUtil.INSTANCE.sortUsingJava7ByIdDesc(accountListTest);
		assertEquals(AccountDataFactory.TEST_COUNT_3_ID, accountListTest.get(0).getId());
		assertEquals(AccountDataFactory.TEST_COUNT_2_ID, accountListTest.get(1).getId());
		assertEquals(AccountDataFactory.TEST_COUNT_1_ID, accountListTest.get(2).getId());
	}
	
	@Test
    public final void shouldSortUsingJava8() {
		SortLambdaUtil.INSTANCE.sortUsingJava8ByIdDesc(accountListTest);
		assertEquals(AccountDataFactory.TEST_COUNT_3_ID, accountListTest.get(0).getId());
		assertEquals(AccountDataFactory.TEST_COUNT_2_ID, accountListTest.get(1).getId());
		assertEquals(AccountDataFactory.TEST_COUNT_1_ID, accountListTest.get(2).getId());
    }
	
}
