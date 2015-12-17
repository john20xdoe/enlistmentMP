package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.notBlank;
import static org.apache.commons.lang3.Validate.notNull;

import org.apache.commons.lang3.StringUtils;

public class Section {
	private final String sectionId;
	private final Schedule schedule;
	private int studentCount;
	
	public Section(String sectionId, Schedule schedule) {
		notBlank(sectionId);
		notNull(schedule);
		
		if(!StringUtils.isAlphanumeric(sectionId)){
			throw new IllegalArgumentException("sectionId must be alphanumeric, was "+sectionId);
		}
		this.sectionId = sectionId;
		this.schedule = schedule;
	}
	
	public void checkConflict(Section section){
		if(this.schedule.equals(section.schedule)){
			throw new ScheduleConflictException("Attempt to enlist section with conflict");
		}
	}

	@Override
	public String toString() {
		return "sectionId=" + sectionId;
	}
}
