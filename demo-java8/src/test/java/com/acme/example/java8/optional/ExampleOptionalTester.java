package com.acme.example.java8.optional;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class ExampleOptionalTester {

	private final String DEFAULT_VALUE = "none";
	
	private final String NULLABLE_STRING = null;
	
	private final String NO_NULLABLE_STRING = "test";

	private Optional<String> optionalTest; 
	
	@Before
	public final void setUp() throws Exception {
	}
	
	@Test
    public final void shouldIsPresentNull() {
		optionalTest = Optional.ofNullable(NULLABLE_STRING);
		
		assertFalse(optionalTest.isPresent());
		assertEquals(DEFAULT_VALUE,optionalTest.orElse(DEFAULT_VALUE));
		assertEquals(DEFAULT_VALUE,optionalTest.orElseGet( () -> DEFAULT_VALUE));
		assertEquals(DEFAULT_VALUE,optionalTest.map( s -> s + " changed").orElse(DEFAULT_VALUE));
	}
	
	@Test
    public final void shouldIsPresentNoNull() {
		optionalTest = Optional.ofNullable(NO_NULLABLE_STRING);
		
		assertTrue(optionalTest.isPresent());
		assertEquals(NO_NULLABLE_STRING,optionalTest.orElse(DEFAULT_VALUE));
		assertEquals(NO_NULLABLE_STRING,optionalTest.orElseGet( () -> DEFAULT_VALUE));
		assertEquals(NO_NULLABLE_STRING+" changed",optionalTest.map( s -> s +" changed").orElse(DEFAULT_VALUE));
	}

}
