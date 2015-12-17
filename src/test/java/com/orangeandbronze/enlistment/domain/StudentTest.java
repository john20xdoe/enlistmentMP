package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

import com.orangeandbronze.enlistment.domain.*;

public class StudentTest {
	
	@Test
	public void createStudentOK(){
		Student student = new Student(1);
	}
	@Test(expected=NullPointerException.class)
	public void createStudentNullIDShouldFail(){
		Student student = new Student(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void createStudentNegativeIDShouldFail(){
		Student student = new Student(-20);
	}
	@Test
	public void checkEquals(){
		Student stu1 = new Student(10);
		Student stu2 = stu1;
		assertEquals(stu1,stu2);
	}
	@Test
	public void checkToString(){
		Student student = new Student(867);
		assertEquals("867",student.toString());
	}
	

}
