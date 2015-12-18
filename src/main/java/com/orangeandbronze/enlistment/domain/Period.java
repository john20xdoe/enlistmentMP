package com.orangeandbronze.enlistment.domain;

public enum Period{
	//TODO add javadoc for each enum  to indicate proper time
	/** 08:30-10:00*/
	H0830_1000 (830,1000), 
	
    H0900_1100 (900,1100),
	H1000_1130 (1000,1130), 
	H1030_1330 (1030, 1330),
	H1130_1300 (1130, 1300), 
	H1300_1430 (1300, 1430), 
	H1400_1600 (1400, 1600),
	H1430_1600 (1430, 1600), 
	H1600_1730 (1600,1730);
    
	private final int fromTime;
	private final int toTime;
	
	private Period(int fromTime, int toTime){
			this.fromTime = fromTime;
			this.toTime = toTime;
	}
	
	public boolean conflictsWith(Period other){
		
		return (this.fromTime > other.fromTime && this.fromTime< other.toTime) ||
                (other.fromTime > this.fromTime&& other.fromTime < this.toTime);
	}
	
}
