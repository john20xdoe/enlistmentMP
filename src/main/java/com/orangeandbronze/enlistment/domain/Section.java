package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.notBlank;
import static org.apache.commons.lang3.Validate.notNull;

import org.apache.commons.lang3.StringUtils;

public class Section {
	private final String sectionId;
	private final Semester semester;
	private final Schedule schedule;
	private final Room room;
	private final Subject subject;
	private int studentCount = 0;
	
	public Section(String sectionId, 
			Semester semester, 
			Schedule schedule, 
			Room room, 
			Subject subject) {
		notBlank(sectionId);
		notNull(schedule);
		
		if(!StringUtils.isAlphanumeric(sectionId)){
			throw new IllegalArgumentException("sectionId must be alphanumeric, was "+sectionId);
		}
		this.sectionId = sectionId;
		this.semester = semester;
		this.schedule = schedule;
		this.room = room;
		this.subject = subject;
		
	}
	
	public boolean hasSameSubject(Section otherSection){
		if(this.subject.equals(otherSection.subject)){
			return true;
		}
		return false;
	}
	//TODO: to be removedin
	/*
	public boolean hasPrereqSubject(Section otherSection){
		if(otherSection.subject.hasPrerequisite()){
			return true;
		}
		return false;
	}*/
	
	public Subject getPrereqSubject(){
		return this.subject.getPrerequisite();
	}
	
	/*public boolean hasSameSubject(Section otherSection){
		if(this.subject.equals(otherSection.subject)){
			return true;
		}
		return false;
	}*/
	
	//TODO refactor to support semesters?
	public void checkConflict(Section section){
		if(this.schedule.equals(section.schedule)){
			throw new ScheduleConflictException("Attempt to enlist section with conflict");
		}
	}

	@Override
	public String toString() {
		return sectionId;
	}
	}
