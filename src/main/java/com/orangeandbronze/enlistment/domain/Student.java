package com.orangeandbronze.enlistment.domain;

import java.util.*;

import static org.apache.commons.lang3.Validate.*;

public class Student {
	private final Integer studentNumber;
	private final Collection<SemesterEnlistment> semesterEnlistment = new HashSet<>();  //we use HashSet to enforce uniqueness of sections
	public final static Student NONE = new Student(0); //for null pattern matching
	
	public Student(Integer studentNumber){
		notNull(studentNumber);
		if (studentNumber < 0){
			throw new IllegalArgumentException("studentNumber cannot be negative, was: " + studentNumber);
		}
		this.studentNumber = studentNumber;
	}
	
	//TODO: To be refactored - not used
	public void enlist(SemesterEnlistment newSemesterEnlistment){
		notNull(newSemesterEnlistment);
		hasTakenPrerequisite(newSemesterEnlistment);
		this.semesterEnlistment.add(newSemesterEnlistment);
	}
	
	public void enlist(Section section){
		Collection<SemesterEnlistment> semesterEnlistmentCopy = new HashSet<>();
		semesterEnlistment.addAll(this.semesterEnlistment);
		notNull(section);
		boolean foundSemEnlist = false;
		for(SemesterEnlistment semEnlist : semesterEnlistmentCopy){
			if(semEnlist.getSemester().equals(section.getSemester())){
				foundSemEnlist = true;
				semEnlist.enlistSection(section);
			}
		}
		
		if(!foundSemEnlist){
			SemesterEnlistment newSemEnlist = new SemesterEnlistment(section.getSemester());
			newSemEnlist.enlistSection(section);
			hasTakenPrerequisite(newSemEnlist);
			this.semesterEnlistment.add(newSemEnlist);
		}
	}
	
	private void hasTakenPrerequisite(SemesterEnlistment newSemesterEnlistment){
		if(newSemesterEnlistment.hasPrereqSubject()){
			Collection<SemesterEnlistment> previousSemesterEnlistments = 
					collectPreviousSemesterPrior(newSemesterEnlistment);
			
			Collection<Subject> prereqSubjects = newSemesterEnlistment.collectPrereqSubjects();
			
			Collection<Subject> matchedSubjects = new HashSet<>();
			
			for(SemesterEnlistment semesterEnlistment : previousSemesterEnlistments){
				matchedSubjects.addAll(semesterEnlistment.getMatchingSubjects(prereqSubjects));
			}
			//TODO: for improvement Specify specific subjects with prereq with sections
			for(Subject prereqSubject : prereqSubjects){
				if(!matchedSubjects.contains(prereqSubject)){
					throw new PrerequisiteSubjectNotFoundException("Prequisite subjects "+prereqSubjects+" must be taken first before enlisting new section");
				}
			}
		}
	}
	
	private Collection<SemesterEnlistment> collectPreviousSemesterPrior(SemesterEnlistment newSemesterEnlistment){
		Collection<SemesterEnlistment> semEnlistments = new HashSet<>(this.semesterEnlistment);
		Collection<SemesterEnlistment> previousSemEnlistments = new HashSet<>();
		
		for(SemesterEnlistment currentSemEnlist : semEnlistments){
			if(currentSemEnlist.getSemester().isPrevious(newSemesterEnlistment.getSemester())){
					previousSemEnlistments.add(currentSemEnlist);
			}
		}
		
		return previousSemEnlistments;
	}
	
	public Collection<SemesterEnlistment> getSemesterEnlistment() {
		return new ArrayList<>(semesterEnlistment);  //defensive copy
	}
	
	public boolean wasMemberOf(Section section){
		for (SemesterEnlistment enlistments : semesterEnlistment){
			for (Section sectionFromEnlistment : enlistments.getSections()){
				if (section == sectionFromEnlistment) 
					return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return ""+studentNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentNumber == null) ? 0 : studentNumber.hashCode());
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
		Student other = (Student) obj;
		if (studentNumber == null) {
			if (other.studentNumber != null)
				return false;
		} else if (!studentNumber.equals(other.studentNumber))
			return false;
		return true;
	}
	
}