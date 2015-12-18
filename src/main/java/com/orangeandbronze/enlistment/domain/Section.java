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

	public Section(String sectionId, Semester semester, Schedule schedule, Room room, Subject subject) {
		notBlank(sectionId);
		notNull(schedule);

		if (!StringUtils.isAlphanumeric(sectionId)) {
			throw new IllegalArgumentException("sectionId must be alphanumeric, was " + sectionId);
		}
		this.sectionId = sectionId;
		this.semester = semester;
		this.schedule = schedule;
		this.room = room;
		this.subject = subject;

	}

	public Semester getSemester() {
		return semester;
	}

	public boolean hasSameSubject(Section otherSection) {
		return (this.subject.equals(otherSection.subject));
	}
	
	public boolean hasPrereqSubject(){
		if(this.subject.hasPrerequisite()){
			return true;
		}
		return false;
	}
	
	public Subject getPrereqSubject() {
		return this.subject.getPrerequisite();
	}
	
	public boolean hasSameSubject(Subject otherSubject){
		if(this.subject.equals(otherSubject)){
			return true;
		}
		return false;
	}

	public void checkScheduleConflict(Section section) {
		if (this.semester == section.getSemester()) {
			if (this.schedule.equals(section.schedule)) {
				throw new ScheduleConflictException("Schedule for " + this + " [" + schedule + "] conflicts with "
						+ section + "[" + section.schedule + "]");
			}
		} //add else ? should we throw Exception if not the same sem; nachecheck na kasi before icall to
	}

	public void isRoomFull() {
		if (room.isAtMax(studentCount)) {
			throw new RoomFullException("Section with id: " + sectionId + " with is already full: room capacity is only "+room.getMaxCapacity());
		}
	}

	@Override
	public String toString() {
		return sectionId;
	}
	
	
	
}
