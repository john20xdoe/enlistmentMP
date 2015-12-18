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
		Semester sem2015 = new Semester(2015,SemType.FIRST);
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
		Semester sem2015 = new Semester(2015,SemType.FIRST);
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

}
