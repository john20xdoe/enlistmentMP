package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;
import com.orangeandbronze.enlistment.domain.*;

import org.junit.Test;

public class SemesterTest {

	@Test
	public void semWithValidArgsShouldBeCreatedOK() {
		Semester sem = new Semester(2005,SemType.FIRST);
	}

	@Test(expected=NullPointerException.class)
	public void semWithNullYearOKSemType(){
		Semester sem = new Semester(null,SemType.SECOND);
	}
	
	@Test(expected=NullPointerException.class)
	public void scheduleWithOKDayNullPeriod(){
		Semester sem = new Semester(2010,null);
	}
	@Test
	public void hasInvalidYear4DigitsOrLess(){
		Semester sem = new Semester(3020,SemType.FIRST);
	}
	@Test(expected=IllegalArgumentException.class)
	public void hasInvalidYearGreaterThan9999(){
		Semester sem = new Semester(10000,SemType.FIRST);
	}

}
