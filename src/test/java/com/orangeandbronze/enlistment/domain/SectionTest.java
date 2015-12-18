package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class SectionTest {

	@Test
	public void verifyEqualsShouldBeEqualIfSameAssigned(){
		Semester sem2015 = new Semester(2015,SemesterType.FIRST);
		Schedule schedMTH = new Schedule(Days.MTH,Period.H0830_1000);		

		Subject polsci1 = Subject.POLSCI101;
		Room room1 = new Room("GALIUS",1);
		Section sec1 = new Section("BSCS1A", sem2015, schedMTH,room1,polsci1);
		Section sec2 = sec1;
		assertTrue(sec1==sec2);
	}
	
	@Test
	public void verifyEqualsShouldNotBeEqualIfInstantiated(){
		Semester sem2015 = new Semester(2015,SemesterType.FIRST);
		Schedule schedMTH = new Schedule(Days.MTH,Period.H0830_1000);		

		Subject polsci1 = Subject.POLSCI101;
		Room room1 = new Room("GALIUS",1);
		Section sec1 = new Section("BSCS1A", sem2015, schedMTH,room1,polsci1);
		Section sec2 = new Section("BSCS1A", sem2015, schedMTH,room1,polsci1);
		assertFalse(sec1==sec2);
	}
	
}
