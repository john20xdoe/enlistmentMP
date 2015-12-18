package com.orangeandbronze.enlistment.domain;


import static org.apache.commons.lang3.Validate.*;
import java.util.*;

public class SemesterEnlistment {
	private final Semester semester;
	private  Collection<Section> sections = new HashSet<>();
	
	public SemesterEnlistment(Semester semester) {
		notNull(semester);
		this.semester=semester;
	}
	
	public Collection<Section> getSections(){
		return new ArrayList<>(sections);
	}

	public void enlistSection(Section otherSection){
		
		if (otherSection.getSemester() != semester) {
			throw new SemesterSectionMismatch("The section " + otherSection + "'s semester should match this semester " + semester + ", was " +  otherSection.getSemester());
		}
				
		validateSectionConflicts(otherSection);
		
		this.sections.add(otherSection);
		
	}
	
	private void validateSectionConflicts(Section otherSection){
		Collection<Section> sectionsCopy = new HashSet<>(sections);
		for(Section currentSection : sectionsCopy){
			if(currentSection.hasSameSubject((otherSection))){
				throw new DuplicateSectionException("Cannot enlist section "+otherSection+" because an existing section with the same subject "+otherSection.getSubject()+" was already enlisted");
			}
			
			currentSection.checkScheduleConflict(otherSection);
		}
	}
	
	//TODO: Remove duplicate codes
	public boolean hasPrereqSubject(SemesterEnlistment semesterEnlistment){
		return matchEnlistmentsPrereqs(new HashSet<>(semesterEnlistment.sections));
	}
	
	public boolean hasPrereqSubject(){
		return matchEnlistmentsPrereqs(new HashSet<>(this.sections));
	}
	
	private boolean matchEnlistmentsPrereqs(Collection<Section> sectionsCopy){
		for(Section section : sectionsCopy){
			if(section.hasPrereqSubject()){
				return true;
			}
		}
		return false;
	}
	
	
	public Collection<Subject> collectPrereqSubjects(){
		Collection<Section> sectionsCopy = new HashSet<>(this.sections);
		Collection<Subject> prereqSubjects = new HashSet<>();
		for(Section section : sectionsCopy){
			if(section.hasPrereqSubject()){
				prereqSubjects.add(section.getPrereqSubject());
			}
		}
		return prereqSubjects;
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
