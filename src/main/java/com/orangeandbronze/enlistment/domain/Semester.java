package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

public class  Semester {
	private final Integer academicYear;
	private final SemesterType sem;
	
	public Semester(Integer academicYear, SemesterType sem){
		final int yearLimit = 9999;
		notNull(academicYear);
		notNull(sem);
		if (academicYear > yearLimit || academicYear <= 0) {
			throw new IllegalArgumentException("academicYear should be 4 digits or less, was "+ academicYear);
		}
		this.academicYear = academicYear;
		this.sem = sem;
	}
	
	public boolean isPrevious(Semester otherSemester){
		
		if(this.academicYear.equals(otherSemester.academicYear)){
			return this.sem.isPreviousSem(otherSemester.sem);
		}
		else{
			return this.academicYear < otherSemester.academicYear;
		}
	}

	@Override
	public String toString() {
		return "Semester [academicYear=" + academicYear + ", sem=" + sem + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((academicYear == null) ? 0 : academicYear.hashCode());
		result = prime * result + ((sem == null) ? 0 : sem.hashCode());
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
		Semester other = (Semester) obj;
		if (academicYear == null) {
			if (other.academicYear != null)
				return false;
		} else if (!academicYear.equals(other.academicYear))
			return false;
		if (sem != other.sem)
			return false;
		return true;
	}
	
}