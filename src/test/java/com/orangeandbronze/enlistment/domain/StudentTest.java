package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

import com.orangeandbronze.enlistment.domain.*;

public class StudentTest {
	
	@Test
	public void createStudentOK(){
		Student student = new Student(1);
	}
	@Test(expected=NullPointerException.class)
	public void createStudentNullIDShouldFail(){
		Student student = new Student(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void createStudentNegativeIDShouldFail(){
		Student student = new Student(-20);
	}
	@Test
	public void checkEquals(){
		Student stu1 = new Student(10);
		Student stu2 = stu1;
		assertEquals(stu1,stu2);
	}
	@Test
	public void checkToString(){
		Student student = new Student(867);
		assertEquals("867",student.toString());
	}
	
	@Test
	public void checkIfStudentIsMemberOfASectionShouldBeOK(){		
		Subject polsci1 = Subject.POLSCI101;
		Room room1 = new Room("GALIUS",1);
		Semester sem2015 = new Semester(2015,SemesterType.FIRST);
		Schedule schedMTH = new Schedule(Days.MTH,Period.H0830_1000);
		Section sec1 = new Section("BSCS1A", sem2015, schedMTH,room1,polsci1);

		SemesterEnlistment sm = new SemesterEnlistment(sem2015);
		sm.enlistSection(sec1);
		Student barack = new Student(100);
		barack.enlist(sm);
		
		assertTrue(barack.wasMemberOf(sec1));		
	}
	
	@Test
	public void checkIfStudentIsMemberOfASectionShouldFail(){		
		Semester sem2015 = new Semester(2015,SemesterType.FIRST);
		Schedule schedMTH = new Schedule(Days.MTH,Period.H0830_1000);		

		Subject polsci1 = Subject.POLSCI101;
		Room room1 = new Room("GALIUS",1);
		Section sec1 = new Section("BSCS1A", sem2015, schedMTH,room1,polsci1);

		Subject polsci2 = Subject.POLSCI102;
		Room room2 = room1;
		Section sec2 = new Section("BSCS1A", sem2015, schedMTH,room1,polsci1);
		
		SemesterEnlistment sm = new SemesterEnlistment(sem2015);
		sm.enlistSection(sec1);
		Student barack = new Student(100);
		barack.enlist(sm);
		
		assertFalse(barack.wasMemberOf(sec2));
	}
	
	@Test(expected = PrerequisiteSubjectNotFoundException.class)
	public void testSemesterEnlismentPrereqNotFound(){
		
		Student student = new Student(123);
		
		Semester semester1 = new Semester(2014, SemesterType.FIRST);
		SemesterEnlistment semesterEnlistment1 = new SemesterEnlistment(semester1);
		
		Schedule schedule1 = new Schedule(Days.MTH, Period.H0830_1000);
		Schedule schedule2 = new Schedule(Days.TF, Period.H0830_1000);
		Room room1 = new Room("Room1", 5);
		Section section1 = new Section("AAA111",semester1,schedule1,room1,Subject.SCI101);
		Section section2 = new Section("AAA222",semester1,schedule2,room1,Subject.ENG101);
		semesterEnlistment1.enlistSection(section1);
		semesterEnlistment1.enlistSection(section2);
		
		Semester semester2 = new Semester(2015, SemesterType.FIRST);
		SemesterEnlistment semesterEnlistment2 = new SemesterEnlistment(semester2);
		
		Schedule schedule3 = new Schedule(Days.MTH, Period.H0830_1000);
		Schedule schedule4 = new Schedule(Days.TF, Period.H0830_1000);
		Room room2 = new Room("Room1", 5);
		Section section3 = new Section("BBB111",semester2,schedule3,room2,Subject.POLSCI102);
		Section section4 = new Section("BBB222",semester2,schedule4,room2,Subject.ENG202);
		semesterEnlistment2.enlistSection(section3);
		semesterEnlistment2.enlistSection(section4);
		
		student.enlist(semesterEnlistment1);
		student.enlist(semesterEnlistment2);
	}

	@Test(expected=DuplicateSectionException.class)
	public void checkIfStudentEnlistToSameSectionShouldFail(){		
		Semester sem2015 = new Semester(2015,SemesterType.FIRST);
		Schedule schedMTH = new Schedule(Days.MTH,Period.H0830_1000);		

		Subject polsci1 = Subject.POLSCI101;
		Room room1 = new Room("GALIUS",1);
		Section sec1 = new Section("BSCS1A", sem2015, schedMTH,room1,polsci1);
		Section sec2 = new Section("BSCS1A", sem2015, schedMTH,room1,polsci1);
				
		SemesterEnlistment sm = new SemesterEnlistment(sem2015);
		sm.enlistSection(sec1);
		sm.enlistSection(sec2);  //should throw DuplicateSectionException here
		//Student barack = new Student(100);
		//barack.enlist(sm);
	}
	
}
