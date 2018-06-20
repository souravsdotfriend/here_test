package com.here.assignment.parkingLot.tasks.impl;

import com.here.assignment.parkingLot.beans.Vehicle;
import com.here.assignment.parkingLot.tasks.Releaser;

public class SingleEntryReleaser implements Releaser {

	private Vehicle[] parkingSlots;
	
	public SingleEntryReleaser(Vehicle[] parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

	@Override
	public int release(int slot) {
		int indexedSlot = slot-1;
		if(parkingSlots[indexedSlot]==null)
			return -100;
		parkingSlots[indexedSlot] = null;
		return slot;
	}

}
