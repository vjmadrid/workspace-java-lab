
package com.acme.example.java8.repeatable.annotation;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ExampleRepeatableAnnotationTester {
	
	private CustomEventJava8 customEvent;
	
	@Before
	public final void setUp() throws Exception {
		customEvent = new CustomEventJava8();
	}
	
	@Test
    public final void shouldRepeatableAnnotationJava7() {
		CustomTime customTime = customEvent.getClass().getAnnotation(CustomTime.class);
		CustomDuration[] customDurations = customTime.value();
		
		//CustomTime[] customTimes = customEvent.getClass().getAnnotationsByType(CustomTime.class);
		//CustomDuration[] customDurations = customTimes[0].value();
		
		assertEquals(1,customDurations[0].hour());
		assertEquals(2,customDurations[1].hour());
	}
	
	@Test
    public final void shouldRepeatableAnnotationJava8() {
		CustomDuration[] customDurations = customEvent.getClass().getAnnotationsByType(CustomDuration.class);
		
		assertEquals(1,customDurations[0].hour());
		assertEquals(2,customDurations[1].hour());
	}
	

}
