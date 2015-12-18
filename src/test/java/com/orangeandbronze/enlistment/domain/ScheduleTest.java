package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;
import com.orangeandbronze.enlistment.domain.Period;

import org.junit.Test;

public class ScheduleTest {

	@Test
	public void scheduleWithValidArgsShouldBeCreatedOK() {
		Schedule sched = new Schedule(Days.MTH,Period.H0830_1000);
	}

	@Test(expected=NullPointerException.class)
	public void scheduleWithNullDayOKPeriod(){
		Schedule sched = new Schedule(null,Period.H0830_1000);
	}
	
	@Test(expected=NullPointerException.class)
	public void scheduleWithOKDayNullPeriod(){
		Schedule sched = new Schedule(Days.TF,null);
	}
}
