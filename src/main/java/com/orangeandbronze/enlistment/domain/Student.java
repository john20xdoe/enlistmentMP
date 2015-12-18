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
	
	public void enlist(SemesterEnlistment newSemesterEnlistment){
		notNull(newSemesterEnlistment);
		
		if(newSemesterEnlistment.hasPrereqSubject()){
			Collection<SemesterEnlistment> previousSemesterEnlistments = 
					collectPreviousSemesterPrior(newSemesterEnlistment);
			
			Collection<Subject> prereqSubjects = newSemesterEnlistment.collectPrereqSubjects();
			
			Collection<Subject> matchedSubjects = new HashSet<>();
			
			for(SemesterEnlistment semesterEnlistment : previousSemesterEnlistments){
				matchedSubjects.addAll(semesterEnlistment.getMatchingSubjects(prereqSubjects));
			}
			
			for(Subject prereqSubject : prereqSubjects){
				if(!matchedSubjects.contains(prereqSubject)){
					throw new PrerequisiteSubjectNotFoundException("Prequisite subjects "+prereqSubjects+" must be taken first before enlisting new section");
				}
			}
		}
		
		this.semesterEnlistment.add(newSemesterEnlistment);
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
				if (section == sectionFromEnlistment) return true;
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