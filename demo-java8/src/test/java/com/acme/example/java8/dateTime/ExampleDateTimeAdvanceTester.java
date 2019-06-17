
package com.acme.example.java8.dateTime;


import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ExampleDateTimeAdvanceTester {
	
	private int YEAR = 2017;
	
	@Before
	public final void setUp() throws Exception {
	}
	
	@Test
    public final void shouldCheckPeriod() {			
		final LocalDate fromDate = LocalDate.of(YEAR, Month.JANUARY,1);
		final LocalDate toDate = LocalDate.of(YEAR, Month.AUGUST,1);
		final Period period = Period.between(fromDate, toDate);
		
		assertEquals("P7M",period.toString());
		assertEquals(7,period.getMonths());
	}
	
	@Test
    public final void shouldCheckDuration() {			
		final LocalDateTime fromDate = LocalDateTime.of(YEAR, Month.JANUARY,1,0,0,0);
		final LocalDateTime toDate = LocalDateTime.of(YEAR, Month.AUGUST,1,0,0,0);
		final Duration duration = Duration.between(fromDate, toDate);
		
		assertEquals("PT5088H",duration.toString());
		assertEquals(212,duration.toDays());
	}
	
	@Test
    public final void shouldCheckChronoUnits() {			
		final LocalDateTime date = LocalDateTime.of(YEAR, Month.JANUARY,1,0,0,0);
		
		final LocalDateTime nextMonth = date.plus(1, ChronoUnit.MONTHS);
		assertEquals(Month.FEBRUARY,nextMonth.getMonth());
		
		final LocalDateTime nextDecade = date.plus(1, ChronoUnit.DECADES);
		assertEquals(2027,nextDecade.getYear());
	}
	
	@Test
    public final void shouldCheckTemporalAdjuster() {			
		final LocalDate date = LocalDate.of(YEAR, Month.JANUARY,1);
		
		final LocalDate nextFriday = date.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
		assertEquals(5,nextFriday.getDayOfMonth());
	}
	
	@Test
    public final void shouldCheckInstant() {
		final LocalDateTime dateTime = LocalDateTime.now(); 
		final Instant instant = new Date().toInstant();	
		final ZoneId currentZone = ZoneId.systemDefault();
		final LocalDateTime anotherDateTime = LocalDateTime.ofInstant(instant, currentZone);
		
		System.out.println("Human Instant :: "+instant);
		System.out.println("Machine Instant :: "+instant.toEpochMilli());
		
		assertEquals(dateTime,anotherDateTime);
	}

}
