package com.here.assignment.parkingLot.tasks;

public interface Checker {
	void checkStatus();
	String findVehiclesByColor(String color);
	int findSlotByRegistrationNumber(String registrationNumber);
	String findSlotsByColor(String string);
}
