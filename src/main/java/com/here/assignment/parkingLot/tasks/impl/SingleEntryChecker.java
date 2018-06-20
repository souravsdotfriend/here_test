package com.here.assignment.parkingLot.tasks.impl;

import com.here.assignment.parkingLot.beans.Vehicle;
import com.here.assignment.parkingLot.tasks.Checker;

public class SingleEntryChecker implements Checker {

	private Vehicle[] parkingSlots;
	
	public SingleEntryChecker(Vehicle[] parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

	@Override
	public void checkStatus() {
		System.out.println("Slot No.    Registration No    Colour");
		
		for(int i=0;i<parkingSlots.length;i++){
			Vehicle vehicle = parkingSlots[i];
			if(vehicle==null) continue;
			System.out.println((i+1)+"\t"+vehicle.getRegistrationNumber()+"\t"+vehicle.getColor());
		}
	}

	@Override
	public String findSlotsByColor(String color) {
		
		String res = "";
		for(int i=0;i<parkingSlots.length;i++){
			Vehicle vehicle = parkingSlots[i];
			if(vehicle!=null && vehicle.getColor().equals(color)) {
				res += ","+(i+1);
			}
		}
		return res.length()==0?res:res.substring(1);
	}

	@Override
	public int findSlotByRegistrationNumber(String registrationNumber) {
		for(int i=0;i<parkingSlots.length;i++){
			Vehicle vehicle = parkingSlots[i];
			if(vehicle!=null && vehicle.getRegistrationNumber().equals(registrationNumber)) {
				return (i+1);
			}
		}
		return -100;
	}

	@Override
	public String findVehiclesByColor(String color) {
		String res = "";
		for(int i=0;i<parkingSlots.length;i++){
			Vehicle vehicle = parkingSlots[i];
			if(vehicle!=null && vehicle.getColor().equals(color)) {
				res += ","+vehicle.getRegistrationNumber();
			}
		}
		
		return res.length()==0?res:res.substring(1);
	}

}
