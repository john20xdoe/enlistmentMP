package com.orangeandbronze.enlistment.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import com.orangeandbronze.enlistment.domain.*;

public class RoomTest extends RuntimeException {

	@Test
	public void roomWithValidNameShouldBeOK(){
		Room room1 = new Room("ROSE1",2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void roomWithInvalidNameShouldThrowException(){
		Room room1 = new Room("RO$E",2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void roomWithZeroMaxCapacityShouldThrowException(){
		Room room1 = new Room("ROSE1",0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void roomWithNegativeMaxCapacityShouldThrowException(){
		Room room1 = new Room("ROSE1",-2);
	}

}
