package com.orangeandbronze.enlistment.service;

import java.util.Collection;

import com.orangeandbronze.enlistment.dao.SectionDAO;
import com.orangeandbronze.enlistment.dao.StudentDAO;
import com.orangeandbronze.enlistment.domain.Section;
import com.orangeandbronze.enlistment.domain.SemesterEnlistment;
import com.orangeandbronze.enlistment.domain.Student;

public class EnlistService {
	
	private SectionDAO sectionDao;
	private StudentDAO studentDao;
	
	public void enlist(int studentNo, String sectionId) {
		// TODO: Implement this method
		Section section = sectionDao.findBySectionId(sectionId);
		Student student = studentDao.findByStudentId(studentNo);
		
		Collection<SemesterEnlistment> semesterEnlistment = student.getSemesterEnlistment();
		//semesterEnlistment.add(); 
		studentDao.save(student);
	}

	public void setSectionDao(SectionDAO sectionDao) {
		this.sectionDao = sectionDao;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}
	
	
}
