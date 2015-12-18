package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashSet;

import javax.sound.midi.ControllerEventListener;

import org.junit.Ignore;
import org.junit.Test;

public class SemesterEnlistmentTest {

	@Test(expected = DuplicateSectionException.class)
	public void testDuplicateSubjectInSemEnlistment() {
		Schedule schedule = new Schedule(Days.MTH, Period.H0830_1000);
		Room room = new Room("Room1", 5);
		Semester semester1 = new Semester(2015, SemesterType.FIRST);
		Section section1 = new Section("AAA111",semester1,schedule,room,Subject.ENG101);
		Section section2 = new Section("BBB222",semester1,schedule,room,Subject.ENG101);
		SemesterEnlistment semesterEnlistment = new SemesterEnlistment(semester1);
		semesterEnlistment.enlistSection(section1);
		semesterEnlistment.enlistSection(section2);
	}
	
	@Test
	public void testCollectPrerequisiteSubject(){
		Semester semester1 = new Semester(2014, SemesterType.FIRST);
		SemesterEnlistment semesterEnlistment1 = new SemesterEnlistment(semester1);
		Schedule schedule1 = new Schedule(Days.MTH, Period.H0830_1000);
		Schedule schedule2 = new Schedule(Days.TF, Period.H0830_1000);
		Room room1 = new Room("Room1", 5);
		Section section1 = new Section("AAA111",semester1,schedule1,room1,Subject.SCI202);
		Section section2 = new Section("AAA222",semester1,schedule2,room1,Subject.ENG202);
		semesterEnlistment1.enlistSection(section1);
		semesterEnlistment1.enlistSection(section2);
		
		Collection<Subject> subjects = semesterEnlistment1.collectPrereqSubjects();
		
		assertEquals(2, subjects.size());
	}
	
	@Test
	public void testMatchingSubjectWithPrereqSubjectAllMatch(){
		Collection<Subject> prereqSubjects = new HashSet<>();
		prereqSubjects.add(Subject.ENG202);
		prereqSubjects.add(Subject.SCI202);
		
		Semester semester1 = new Semester(2014, SemesterType.FIRST);
		SemesterEnlistment semesterEnlistment1 = new SemesterEnlistment(semester1);
		Schedule schedule1 = new Schedule(Days.MTH, Period.H0830_1000);
		Schedule schedule2 = new Schedule(Days.TF, Period.H0830_1000);
		Room room1 = new Room("Room1", 5);
		Section section1 = new Section("AAA111",semester1,schedule1,room1,Subject.SCI202);
		Section section2 = new Section("AAA222",semester1,schedule2,room1,Subject.ENG202);
		semesterEnlistment1.enlistSection(section1);
		semesterEnlistment1.enlistSection(section2);
		
		Collection<Subject> matchedSubjects = 
				semesterEnlistment1.getMatchingSubjects(prereqSubjects);
		
		assertEquals(2, matchedSubjects.size());
	}
	
	@Test
	public void testMatchingSubjectWithPrereqSubjectNonMatch(){
		Collection<Subject> prereqSubjects = new HashSet<>();
		prereqSubjects.add(Subject.ENG202);
		prereqSubjects.add(Subject.SCI202);
		
		Semester semester1 = new Semester(2014, SemesterType.FIRST);
		SemesterEnlistment semesterEnlistment1 = new SemesterEnlistment(semester1);
		Schedule schedule1 = new Schedule(Days.MTH, Period.H0830_1000);
		Schedule schedule2 = new Schedule(Days.TF, Period.H0830_1000);
		Room room1 = new Room("Room1", 5);
		Section section1 = new Section("AAA111",semester1,schedule1,room1,Subject.FIL103);
		Section section2 = new Section("AAA222",semester1,schedule2,room1,Subject.MATH202);
		semesterEnlistment1.enlistSection(section1);
		semesterEnlistment1.enlistSection(section2);
		
		Collection<Subject> matchedSubjects = 
				semesterEnlistment1.getMatchingSubjects(prereqSubjects);
		
		assertEquals(0, matchedSubjects.size());
	}
}
