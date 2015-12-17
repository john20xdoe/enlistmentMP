package com.orangeandbronze.enlistment.domain;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.Validate.*;

public class Room {

	private final String name;
	private final int maxCapacity;
	
	public Room(String name, int maxCapacity){
		notNull(maxCapacity);
		
		if(!StringUtils.isAlphanumeric(name)){
			throw new IllegalArgumentException("Room Name must be alphanumeric, was "+name);
		};
		
		this.name = name;
		this.maxCapacity = maxCapacity;
	}

	@Override
	public String toString() {
		return "Room [name=" + name + ", maxCapacity=" + maxCapacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
