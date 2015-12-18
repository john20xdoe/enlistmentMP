package com.orangeandbronze.enlistment.domain;


import static org.apache.commons.lang3.Validate.*;
import java.util.*;

public class SemesterEnlistment {
	private final Semester semester;
	private  Collection<Section> sections = new HashSet<>();
	
	// TODO validation of taking a subject together with its prereq
	
	public SemesterEnlistment(Semester semester) {
		notNull(semester);
		this.semester=semester;
	}
	
	public Collection<Section> getSections(){
		return new ArrayList<>(sections);  //defensive copy
	}

	public void enlistSection(Section otherSection){
		if (otherSection.getSemester() != semester) {
			throw new SemesterSectionMismatch("The section " + otherSection + "'s semester should match this semester " + semester + ", was " +  otherSection.getSemester());
		}
		for(Section currentSection : this.sections){
			if(currentSection.hasSameSubject((otherSection))){
				throw new DuplicateSectionException("Cannot enlist section "+otherSection+" because an existing section with the same subject already enlisted");
			}
			//also check if the schedules conflict
			currentSection.checkScheduleConflict(otherSection);
		}
				
		prereqExists(otherSection);
		this.sections.add(otherSection);
		
	}
	
	//TODO for refactoring
	private void prereqExists(Section otherSection){
		for(Section currentSection : this.sections){
			if(!currentSection.hasSameSubject(otherSection) ){
				throw new PrerequisiteSubjectNotFoundException("Cannot enlist section "+otherSection+" because prequisite subject is not found ");
			}
		}
	}
	
	public boolean prereqExists(Collection<Subject> subjectsWithPrereq){
		boolean status = false;
		
		for(Section currentSection : this.sections){
			for(Subject prereqSubject :subjectsWithPrereq){
				if(currentSection.hasSameSubject(prereqSubject)){
						
				}
			}
		}
		return status;
	}
	
	public boolean hasPrereqSubject(SemesterEnlistment semesterEnlistment){
		for(Section section : semesterEnlistment.sections){
			if(section.hasPrereqSubject()){
				return true;
			}
		}
		return false;
	}
	
	public Collection<Subject> collectPrereqSubjects(){
		Collection<Subject> prereqSubjects = new HashSet<>();
		for(Section section : this.sections){
			if(section.hasPrereqSubject()){
				prereqSubjects.add(section.getPrereqSubject());
			}
		}
		return prereqSubjects;
	}
	
	public boolean hasPrereqSubject(){
		for(Section section : this.sections){
			if(section.hasPrereqSubject()){
				return true;
			}
		}
		return false;
	} 
	
	public Collection<Subject> getMatchingSubjects(Collection<Subject> prereqSubjects){
		Collection<Subject> preqSubjectCopy = new HashSet<>(prereqSubjects);
		Collection<Subject> matchingSubjects = new HashSet<>();
		for(Section section : this.sections){
			for(Subject otherSubject : preqSubjectCopy){
				if(section.hasSameSubject(otherSubject)){
					matchingSubjects.add(otherSubject);
				}
			}
		}
		return matchingSubjects;
	}
	

	public Semester getSemester(){
		return this.semester;
	}
	
	@Override
	public String toString() {
		return semester + " " + sections ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sections == null) ? 0 : sections.hashCode());
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
		SemesterEnlistment other = (SemesterEnlistment) obj;
		if (sections == null) {
			if (other.sections != null)
				return false;
		} else if (!sections.equals(other.sections))
			return false;
		if (semester == null) {
			if (other.semester != null)
				return false;
		} else if (!semester.equals(other.semester))
			return false;
		return true;
	}
	
	
	
	
	

}
