package com.acme.example.java8.lambda;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.java8.lambda.service.CustomOperation;

public class ExampleCustomOperationTester {
	
	private CustomOperation customOperation;
	
	@Before
	public final void setUp() throws Exception {
		customOperation = new CustomOperation();
	}
	
	@Test
    public final void shouldAdd() {
		assertEquals(5, customOperation.operate(3, 2, CustomOperation.ADD));
	}
	
	@Test
    public final void shouldSubtraction() {
		assertEquals(1, customOperation.operate(3, 2, CustomOperation.SUBTRACTION));
	}
	
	@Test
    public final void shouldMultiplication() {
		assertEquals(6, customOperation.operate(3, 2, CustomOperation.MULTIPLICATION));
	}
	
}
