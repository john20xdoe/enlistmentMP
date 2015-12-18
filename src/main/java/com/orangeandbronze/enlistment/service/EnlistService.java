package com.orangeandbronze.enlistment.service;

import com.orangeandbronze.enlistment.dao.*;
import com.orangeandbronze.enlistment.domain.*;

public class EnlistService {
	
	private SectionDAO sectionDao;
	private StudentDAO studentDao;
	
	public void enlist(int studentNo, String sectionId) {
		Section section = sectionDao.findBySectionId(sectionId);
		Student student = studentDao.findByStudentId(studentNo);
		student.enlist(section);
		studentDao.save(student);
	}

	public SectionDAO getSectionDao() {
		return sectionDao;
	}

	public void setSectionDao(SectionDAO sectionDao) {
		this.sectionDao = sectionDao;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}	
}
