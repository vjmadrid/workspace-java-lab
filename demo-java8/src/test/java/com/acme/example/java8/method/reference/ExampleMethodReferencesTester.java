package com.acme.example.java8.method.reference;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class ExampleMethodReferencesTester {

	private String[] strArray = {"one", "2" , "three", "four"};
	
	@Before
	public final void setUp() throws Exception {
		
	}
	
	@Test
    public final void shouldSortLambdaExample() {
		
		Arrays.sort(strArray, (String s1, String s2) -> {
			return (s1.length() - s2.length());
		});
		
		assertEquals("2", strArray[0]);
		assertEquals("one", strArray[1]);
		assertEquals("four", strArray[2]);
		assertEquals("three", strArray[3]);
	}
	
	private static int compareByLength(String s1, String s2){
		return (s1.length() - s2.length());
	}
	
	@Test
    public final void shouldSortLambdaReferenceExample() {
		
		Arrays.sort(strArray, ExampleMethodReferencesTester::compareByLength);
		
		assertEquals("2", strArray[0]);
		assertEquals("one", strArray[1]);
		assertEquals("four", strArray[2]);
		assertEquals("three", strArray[3]);
	}
	
	@Test
    public final void shouldSortLambdaReferenceUtilExample() {
		
		SortByLength sortByLength = new SortByLength();
		
		Arrays.sort(strArray, sortByLength::compareByLength);
		
		assertEquals("2", strArray[0]);
		assertEquals("one", strArray[1]);
		assertEquals("four", strArray[2]);
		assertEquals("three", strArray[3]);
	}
	
	@Test
    public final void shouldLambdaReferenceCompareToExample() {
		
		Comparator<String> comparatorLambda = (s1 ,s2) -> s1.compareTo(s2);
		
		Comparator<String> comparatorReference = String::compareTo;
		
		assertEquals(6, comparatorLambda.compare("test", "no test"));
		assertEquals(0, comparatorLambda.compare("test", "test"));
		
		assertEquals(6, comparatorReference.compare("test", "no test"));
		assertEquals(0, comparatorReference.compare("test", "test"));
	}

}
