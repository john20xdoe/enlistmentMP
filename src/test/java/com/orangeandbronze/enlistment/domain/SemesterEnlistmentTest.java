package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class SemesterEnlistmentTest {

	@Test(expected = DuplicateSectionException.class)
	public void testDuplicateSubjectInSemEnlistment() {
		Schedule schedule = new Schedule(Days.MTH, Period.H0830);
		Room room = new Room("Room1", 5);
		Semester semester1 = new Semester(2015, SemType.FIRST);
		Section section1 = new Section("AAA111",semester1,schedule,room,Subject.ENG101);
		Section section2 = new Section("AAA111",semester1,schedule,room,Subject.ENG101);
		SemesterEnlistment semesterEnlistment = new SemesterEnlistment(semester1);
		semesterEnlistment.enlistSection(section1);
		semesterEnlistment.enlistSection(section2);
	}
}
