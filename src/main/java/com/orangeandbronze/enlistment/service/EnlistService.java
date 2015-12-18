package com.orangeandbronze.enlistment.service;

import com.orangeandbronze.enlistment.dao.*;
import com.orangeandbronze.enlistment.domain.*;

public class EnlistService {
	
	private SectionDAO sectionDao;
	private StudentDAO studentDao;
	
	public void enlist(int studentNo, String sectionId) {
		Section section = sectionDao.findBySectionId(sectionId);
		Student student = studentDao.findByStudentId(studentNo);
		
		Semester semester = new Semester(2015, SemesterType.FIRST);
		SemesterEnlistment semesterEnlistment = new SemesterEnlistment(semester);
		semesterEnlistment.enlistSection(section);
		student.enlist(semesterEnlistment);
		studentDao.save(student);
	}

	public void setSectionDao(SectionDAO sectionDao) {
		this.sectionDao = sectionDao;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}	
}
