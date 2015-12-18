package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;
import com.orangeandbronze.enlistment.domain.*;

import org.junit.Test;

public class SemesterTest {

	@Test
	public void semWithValidArgsShouldBeCreatedOK() {
		Semester sem = new Semester(2005,SemesterType.FIRST);
	}

	@Test(expected=NullPointerException.class)
	public void semWithNullYearOKSemType(){
		Semester sem = new Semester(null,SemesterType.SECOND);
	}
	
	@Test(expected=NullPointerException.class)
	public void scheduleWithOKDayNullPeriod(){
		Semester sem = new Semester(2010,null);
	}
	
	@Test
	public void hasInvalidYear4DigitsOrLess(){
		Semester sem = new Semester(3020,SemesterType.FIRST);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void hasInvalidYearGreaterThan9999(){
		Semester sem = new Semester(10000,SemesterType.FIRST);
	}
	
	@Test
	public void testNewSemesterIsPreviousWithSameAcademicYear(){
		
		Semester semester1 = new Semester(2014, SemesterType.FIRST);
		Semester semester2 = new Semester(2014, SemesterType.SECOND);
		
		assertTrue(semester1.isPrevious(semester2));
	}
	
	@Test
	public void testNewSemesterIsPreviousWithDiffAcademicYear(){
		
		Semester semester1 = new Semester(2014, SemesterType.FIRST);
		Semester semester2 = new Semester(2015, SemesterType.SECOND);
		
		assertTrue(semester1.isPrevious(semester2));
	}
	
	@Test
	public void testNewSemesterIsPreviousWithSameSemTypeButDiffYear(){
		
		Semester semester1 = new Semester(2014, SemesterType.FIRST);
		Semester semester2 = new Semester(2015, SemesterType.FIRST);
		
		assertTrue(semester1.isPrevious(semester2));
	}

}
