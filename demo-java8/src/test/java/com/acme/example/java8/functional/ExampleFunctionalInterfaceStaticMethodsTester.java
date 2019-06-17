package com.acme.example.java8.functional;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.java8.functional.service.CustomCountService;
import com.acme.example.java8.functional.service.CustomCountServiceImpl;

public class ExampleFunctionalInterfaceStaticMethodsTester {
	
	private CustomCountService customCountService;
	
	@Before
	public final void setUp() throws Exception {
		customCountService = new CustomCountServiceImpl();
	}
	
	@Test
    public final void shouldDefaultCount() {
		assertEquals(0, customCountService.defaultCount());
	}

}
