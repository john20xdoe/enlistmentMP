package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.orangeandbronze.enlistment.domain.*;

public class StudentTest {
//	@Test
//	public void enlistNoConflict() {
//		Room room1 = new Room("ST.JOHN", 2);
//		Room room2 = new Room("ST.CECILIA", 3);
//		Student student = new Student(1);
//		Section sec1 = new Section("AAA111", new Schedule(Days.MTH, Period.H0830), room1);
//		Section sec2 = new Section("BBB222", new Schedule(Days.MTH, Period.H1000), room2);
//		student.enlist(sec1);
//		student.enlist(sec2);
//		assertTrue(student.getSections().containsAll(Arrays.asList(sec1, sec2)));
//		assertEquals(2, student.getSections().size());
//	}
//
//	@Test(expected = ScheduleConflictException.class)
//	public void enlistSameSchedule() {
//		Room room1 = new Room("ST.JOHN", 2);
//		Room room2 = new Room("ST.CECILIA", 3);
//		Student student = new Student(1);
//		Section sec1 = new Section("AAA111", new Schedule(Days.MTH, Period.H0830), room1);
//		Section sec2 = new Section("AAA211", new Schedule(Days.MTH, Period.H0830), room2);
//		student.enlist(sec1);
//		student.enlist(sec2); // should throw ScheduleConflictException here
//	}
//	
//	/* Rooms Test */
//	@Test(expected = RoomAtFullCapacityException.class)
//	public void addOccupantToFullRoom() {
//		Room room1 = new Room("ST.JOHN", 2);
//		room1.addOccupants(1);
//		room1.addOccupants(1);
//		room1.addOccupants(1); // should throw RoomAtFullCapacityException here
//	}
//
//	@Test
//	public void enlistToSectionWithAvailableRoomCapacity() {
//		// set up rooms for section
//		Room room1 = new Room("ST.PAUL", 2);
//		Section sec1 = new Section("AAA111", new Schedule(Days.MTH, Period.H0830), room1);
//		Student barack = new Student(1);
//		barack.enlist(sec1);
//		assertTrue("Room is not yet full", room1.getCurrentOccupants() < room1.getMaxCapacity());
//	}
//
//	@Test
//	public void enlistToSectionWithFilledRoomCapacityNoException() {
//		// set up rooms for section
//		Room room1 = new Room("ST.LORENZO", 2);
//		Section sec1 = new Section("AAA112", new Schedule(Days.MTH, Period.H0830), room1);
//		Student barack = new Student(1);
//		Student ninoy = new Student(1);
//		barack.enlist(sec1);
//		ninoy.enlist(sec1);
//		assertTrue("Room is afull", room1.getCurrentOccupants() == room1.getMaxCapacity());
//	}
//	
//	@Test(expected = RoomAtFullCapacityException.class)
//	public void enlistToSectionWithFullRoomCapacity() {
//		// set up rooms for section
//		Room room1 = new Room("ST.IGNATIUS", 2);
//		Section sec1 = new Section("AAA113", new Schedule(Days.MTH, Period.H0830), room1);
//		Student barack = new Student(1);
//		Student ninoy = new Student(1);
//		Student lincoln = new Student(1);
//		barack.enlist(sec1);
//		ninoy.enlist(sec1);
//		lincoln.enlist(sec1); // should throw RoomAtFullCapacityException here
//	}
}
