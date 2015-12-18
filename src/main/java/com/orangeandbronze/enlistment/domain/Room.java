package com.orangeandbronze.enlistment.domain;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.Validate.*;

public class Room {

	private final String roomName;
	private final int maxCapacity;
	
	public Room(String name, int maxCapacity){
		notNull(maxCapacity);
		if (maxCapacity <= 0){
			throw new IllegalArgumentException("maxCapacity should a positive non-zero integer, was "+ maxCapacity);
		}
		if(!StringUtils.isAlphanumeric(name)){
			throw new IllegalArgumentException("Room Name must be alphanumeric, was "+name);
		};
		
		this.roomName = name;
		this.maxCapacity = maxCapacity;
	}
	public boolean isAtMax(int currentOccupants){
		return currentOccupants >= maxCapacity; 
	}
	public int getMaxCapacity(){
		return maxCapacity;
	}

	@Override
	public String toString() {
		return "RoomName=" + roomName ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
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
		Room other = (Room) obj;
		if (roomName == null) {
			if (other.roomName != null)
				return false;
		} else if (!roomName.equals(other.roomName))
			return false;
		return true;
	}
	
	
}
