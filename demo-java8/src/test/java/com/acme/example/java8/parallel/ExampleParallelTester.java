package com.acme.example.java8.parallel;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class ExampleParallelTester {

	final static int ARRAY_SIZE = 10 * 1024 * 1024; // 10 MB
	final static int LOOPS = 10; 

	int[] arrayExample = new int[ARRAY_SIZE];

	@Before
	public final void setUp() throws Exception {
		Random rand = new Random(1);
		for (int i = 0; i < arrayExample.length; i++) {
			arrayExample[i] = rand.nextInt(9999999);
		}
	}

	@Test
	public final void shouldParallelProcessing() {

		// Normal Sort
		long tStartNormal = System.currentTimeMillis();
		for (int i = 0; i < LOOPS; i++) {
			int[] toSort = Arrays.copyOf(arrayExample, arrayExample.length);
			Arrays.sort(toSort);
		}
		long tEndNormal = System.currentTimeMillis();
		long tDeltaNormal = tEndNormal - tStartNormal;
		double elapsedSecondsNormal = tDeltaNormal / 1000.0;
		System.err.println("Normal sort: " + elapsedSecondsNormal);
		
		// Parallel Sort
		long tStartParallel = System.currentTimeMillis();
		for (int i = 0; i < LOOPS; i++) {
			int[] toSort = Arrays.copyOf(arrayExample, arrayExample.length);
			Arrays.parallelSort(toSort);
		}
		long tEndParallel = System.currentTimeMillis();
		long tDeltaParallel = tEndParallel - tStartParallel;
		double elapsedSecondsParallel = tDeltaParallel / 1000.0;
		System.err.println("Parallel sort: " + elapsedSecondsParallel);
		
		assertTrue(elapsedSecondsParallel<elapsedSecondsNormal);
	}

}
