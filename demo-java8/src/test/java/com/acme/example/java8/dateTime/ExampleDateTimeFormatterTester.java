
package com.acme.example.java8.dateTime;


import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

public class ExampleDateTimeFormatterTester {
	
	@Before
	public final void setUp() throws Exception {
	}
	
	@Test
    public final void shouldCheckDateTimeFormatterCustom() {			
		final LocalDateTime date = LocalDateTime.of(2015, Month.JANUARY,1,0,0,0);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
		final String dateString = date.format(format);
		
		assertEquals("20150101120000",dateString);
	}
	
	@Test
    public final void shouldCheckDateTimeFormatter() {			
		final LocalDateTime date = LocalDateTime.of(2015, Month.JANUARY,1,0,0,0);
		final String dateString = date.format(DateTimeFormatter.ISO_DATE);
		
		assertEquals("2015-01-01",dateString);
	}

}
