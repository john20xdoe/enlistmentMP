package com.orangeandbronze.enlistment.service;

import org.junit.Test;

import com.orangeandbronze.enlistment.dao.*;
import com.orangeandbronze.enlistment.domain.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

public class EnlistServiceTest {
	
    @Test
    public void enlist() {
    	SectionDAO sectionDao = mock(SectionDAO.class);
    	StudentDAO studentDao = mock(StudentDAO.class);
    	 	
    	EnlistService service = new EnlistService();
    	service.setSectionDao(sectionDao);
    	service.setStudentDao(studentDao);
    	
		final String sectionId = "AAA111";
		final Semester semTest = new Semester(2015, SemType.SECOND);
		final Schedule schedTest = new Schedule(Days.MTH, Period.H1600_1730);
		final Room roomTest = new Room("Room1", 4);
		final Section section1 = new Section(sectionId, semTest, schedTest, roomTest, Subject.ENG101);
		when(sectionDao.findBySectionId(sectionId)).thenReturn(section1);
		sectionDao.save(section1);
		
		final String sectionId2 = "BBB222";
		final Semester semTest2 = new Semester(2015, SemType.SECOND);
		final Schedule schedTest2 = new Schedule(Days.MTH, Period.H1600_1730);
		final Room roomTest2 = new Room("Room1", 4);
		final Section section2 = new Section(sectionId2, semTest2, schedTest2, roomTest2, Subject.ENG101);
		when(sectionDao.findBySectionId(sectionId2)).thenReturn(section2);
		sectionDao.save(section2);
		
		assertEquals("BBB222", section2.toString());
		assertEquals("AAA111", section1.toString());
	
		verify(sectionDao).save(section1);
		verify(sectionDao).save(section2);
	}
}
