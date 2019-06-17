package com.acme.example.java8.base64;


import static org.junit.Assert.assertEquals;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.junit.Before;
import org.junit.Test;

public class ExampleBase64Tester {

	private final String EXAMPLE_TEXT = "test";
	
	private final String ENCODED_EXAMPLE_TEXT = "dGVzdA==";
	
	@Before
	public final void setUp() throws Exception {
	}
	
	@Test
    public final void shouldEncode() {
		final String encoded = Base64.getEncoder().encodeToString(EXAMPLE_TEXT.getBytes(StandardCharsets.UTF_8));
		System.out.println("Encode Text ["+EXAMPLE_TEXT+"] :: ["+encoded+"]");
		assertEquals(ENCODED_EXAMPLE_TEXT, encoded);
	}
	
	@Test
    public final void shouldDecode() {
		final String decoded = new String(Base64.getDecoder().decode(ENCODED_EXAMPLE_TEXT), StandardCharsets.UTF_8);
		System.out.println("Decode Text ["+ENCODED_EXAMPLE_TEXT+"] :: ["+decoded+"]");
		assertEquals(EXAMPLE_TEXT, decoded);
	}

}
