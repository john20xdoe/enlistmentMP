package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

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
		notNull(semester);
		notNull(room);
		notNull(subject);

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

	public boolean hasPrereqSubject() {
		if (subject.hasPrerequisite()) {
			return true;
		}
		return false;
	}

	public Subject getPrereqSubject() {
		return subject.getPrerequisite();
	}

	public boolean hasSameSubject(Subject otherSubject) {

		return this.subject.equals(otherSubject);
	}

	public void checkScheduleConflict(Section section) {
		if (this.semester == section.getSemester() && (this.schedule.equals(section.schedule))) {

			throw new ScheduleConflictException("Schedule for " + this + " [" + schedule + "] conflicts with " + section
					+ "[" + section.schedule + "]");

		}
	}

	public void isRoomFull() {
		if (room.isAtMax(studentCount)) {
			throw new RoomFullException("Section with id: " + sectionId + " is already full: room capacity is only "
					+ room.getMaxCapacity());
		}
	}
	
	public Subject getSubject(){
		return subject;
	}

	@Override
	public String toString() {
		return sectionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sectionId == null) ? 0 : sectionId.hashCode());
		result = prime * result + ((semester == null) ? 0 : semester.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		if (sectionId == null) {
			if (other.sectionId != null)
				return false;
		} else if (!sectionId.equals(other.sectionId))
			return false;
		if (semester == null) {
			if (other.semester != null)
				return false;
		} else if (!semester.equals(other.semester))
			return false;
		return true;
	}
}
