package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;
import com.orangeandbronze.enlistment.domain.Period;
import org.junit.Test;

public class PeriodTest {

	@Test
	public void testPeriodThatConflict() {
		Period mathPeriod = Period.H0830_1000;
		Period sciencePeriod = Period.H0900_1100;
		assertTrue(mathPeriod.conflictsWith(sciencePeriod));
	}
	
	@Test
	public void testPeriodThatDoesNotConflict() {
		Period mathPeriod = Period.H0830_1000;
		Period sciencePeriod = Period.H1130_1300;
		assertFalse(mathPeriod.conflictsWith(sciencePeriod));
	}
	
	@Test
	public void testPeriodThatStartAfterTheOther(){
		boolean isExpectedToConflict = false;
		Period mathPeriod = Period.H0830_1000;
		Period sciencePeriod = Period.H1000_1130;
		assertEquals(isExpectedToConflict, mathPeriod.conflictsWith(sciencePeriod));
	}
	
	@Test
	public void testPeriodThatOverLapInsideAnother(){
		boolean isExpectedToConflict = true;
		Period mathPeriod = Period.H1030_1330; //outer
		Period sciencePeriod = Period.H1130_1300; //inner
		assertEquals(isExpectedToConflict, mathPeriod.conflictsWith(sciencePeriod));
	}

}
