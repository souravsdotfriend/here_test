package com.here.assignment.parkingLot.tasks.impl;

import com.here.assignment.parkingLot.beans.Vehicle;
import com.here.assignment.parkingLot.tasks.Parker;

public class SingleEntryParker implements Parker {

	private Vehicle[] parkingSlots;
	
	public SingleEntryParker(Vehicle[] parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

	@Override
	public int park(Vehicle vehicle) {
		if(parkingSlots==null || parkingSlots.length<1)
			return -100;
		for(int i=0;i<parkingSlots.length;i++){
			if(parkingSlots[i]==null){
				parkingSlots[i] = vehicle;
				return i+1;
			}
		}
		return -100;
	}

}
