package com.orangeandbronze.enlistment.service;

import java.util.Collection;


import com.orangeandbronze.enlistment.dao.*;
import com.orangeandbronze.enlistment.domain.*;

public class EnlistService {
	
	private SectionDAO sectionDao;
	private StudentDAO studentDao;
	
	public void enlist(int studentNo, String sectionId) {
		Section section = sectionDao.findBySectionId(sectionId);
		Student student = studentDao.findByStudentId(studentNo);
		
		Collection<SemesterEnlistment> semesterEnlistment = student.getSemesterEnlistment();
		for(SemesterEnlistment semEnlist : semesterEnlistment) {
			semEnlist.enlistSection(section);
		}
		studentDao.save(student);
	}

	public void setSectionDao(SectionDAO sectionDao) {
		this.sectionDao = sectionDao;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}
	
	
}
