
package com.acme.example.java8.dateTime;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Before;
import org.junit.Test;

public class ExampleDateTimeTester {
	
	private Clock clock;
	
	@Before
	public final void setUp() throws Exception {
	}
	
	@Test
    public final void shouldLocalDate() {			
		final LocalDate date = LocalDate.now();
		final LocalDate dateFromClock = LocalDate.now(Clock.systemUTC());
		
		assertEquals(date,dateFromClock);
	}
	
	@Test
    public final void shouldLocalTime() {			
		final LocalTime time = LocalTime.now();
		final LocalTime timeFromClock = LocalTime.now(Clock.systemUTC());
		
		assertNotSame(time,timeFromClock);
	}
	
	@Test
    public final void shouldLocalDateTime() {			
		final LocalDateTime dateTime = LocalDateTime.now();
		final LocalDateTime dateTimeFromClock = LocalDateTime.now(Clock.systemUTC());
		
		assertNotSame(dateTime,dateTimeFromClock);
	}
	
	@Test
    public final void shouldLocalDateTimetoOther() {
		clock = Clock.systemUTC();
		final LocalDate date = LocalDate.now(clock);
		final LocalTime time = LocalTime.now(clock);
		final LocalDateTime dateTime = LocalDateTime.now(clock);

		assertEquals(time,dateTime.toLocalTime());
		assertEquals(date,dateTime.toLocalDate());
	}
	
	@Test
    public final void shouldGenerateLocalDate() {			
		final LocalDate date = LocalDate.now().withDayOfMonth(1).withMonth(1);
		final LocalDate otherDate = LocalDate.of(2017,1,1);
		
		assertEquals(date,otherDate);
	}
	
	@Test
    public final void shouldGenerateLocalTime() {			
		final LocalTime time = LocalTime.of(22,30,25);
		final LocalTime otherTime = LocalTime.parse("22:30:25");
		
		assertEquals(time,otherTime);
	}
	
	@Test
    public final void shouldZonedDateTime() {			
		final ZonedDateTime zonedDateTime = ZonedDateTime.now();
		final ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(Clock.systemUTC());
		
		assertNotSame(zonedDateTime,zonedDateTimeFromClock);
	}
	
	@Test
    public final void shouldCheckPeriod() {			
		final LocalDate fromDate = LocalDate.of(2015, Month.JANUARY,1);
		final LocalDate toDate = LocalDate.of(2015, Month.AUGUST,1);
		final Period period = Period.between(fromDate, toDate);
		
		assertEquals("P7M",period.toString());
		assertEquals(7,period.getMonths());
	}
	
	@Test
    public final void shouldCheckDuration() {			
		final LocalDateTime fromDate = LocalDateTime.of(2015, Month.JANUARY,1,0,0,0);
		final LocalDateTime toDate = LocalDateTime.of(2015, Month.AUGUST,1,0,0,0);
		final Duration duration = Duration.between(fromDate, toDate);
		
		assertEquals("PT5088H",duration.toString());
		assertEquals(212,duration.toDays());
	}
	
	@Test
    public final void shouldCheckChronoUnits() {			
		final LocalDateTime date = LocalDateTime.of(2015, Month.JANUARY,1,0,0,0);
		
		final LocalDateTime nextMonth = date.plus(1, ChronoUnit.MONTHS);
		assertEquals(Month.FEBRUARY,nextMonth.getMonth());
		
		final LocalDateTime nextDecade = date.plus(1, ChronoUnit.DECADES);
		assertEquals(2025,nextDecade.getYear());
	}

}
