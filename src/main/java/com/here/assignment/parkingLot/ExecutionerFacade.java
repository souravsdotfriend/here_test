package com.here.assignment.parkingLot;

import com.here.assignment.parkingLot.beans.Vehicle;
import com.here.assignment.parkingLot.tasks.Checker;
import com.here.assignment.parkingLot.tasks.Parker;
import com.here.assignment.parkingLot.tasks.Releaser;
import com.here.assignment.parkingLot.tasks.impl.ParkingLotFactory;
import com.here.assignment.parkingLot.tasks.impl.SingleEntryChecker;
import com.here.assignment.parkingLot.tasks.impl.SingleEntryParker;
import com.here.assignment.parkingLot.tasks.impl.SingleEntryReleaser;

public class ExecutionerFacade {

	private Parker parker = null;
	private Releaser releaser = null;
	private Checker checker =null;
    
	public void executeCommand(String line){
		if(line==null || line.equals(""))
			return;
		else if(line.startsWith("create_parking_lot")){
        	String[] split = line.split(" ");
        	ParkingLotFactory factory = new ParkingLotFactory();
        	Vehicle[] slots = factory.createParkingLot(Integer.parseInt(split[1]));
        	parker = new SingleEntryParker(slots);
 	        releaser = new SingleEntryReleaser(slots);
 	        checker = new SingleEntryChecker(slots);
        	System.out.println("Created a parking lot with "+slots.length+" slots");
        }else if(line.startsWith("park")){
        	if(parker==null){
        		System.out.println("need to create parking lot first");
        		return;
        	}
        	String[] split = line.split(" ");
        	Vehicle v = new Vehicle(split[1], split[2]);
        	int park = parker.park(v);
        	if(park==-100)
        		System.out.println("Sorry, parking lot is full");
        	else
        		System.out.println("Allocated slot number: "+park);
        }else if(line.startsWith("leave")){
        	if(releaser==null){
        		System.out.println("need to create parking lot first");
        		return;
        	}
        	String[] split = line.split(" ");
        	int release = releaser.release(Integer.parseInt(split[1]));
        	if(release==-100)
        		System.out.println("no vehicle on that spot");
        	else
        		System.out.println("Slot number "+release+" is free");
        }else if(line.equals("status")){
        	if(checker==null){
        		System.out.println("need to create parking lot first");
        		return;
        	}
        	checker.checkStatus();
        }else if(line.startsWith("registration_numbers_for_cars_with_colour")){
        	if(checker==null){
        		System.out.println("need to create parking lot first");
        		return;
        	}
        	String[] split = line.split(" ");
        	String findVehiclesByColor = checker.findVehiclesByColor(split[1]);
        	System.out.println(findVehiclesByColor);
        }else if(line.startsWith("slot_numbers_for_cars_with_colour")){
        	String[] split = line.split(" ");
        	String findSlotsByColor = checker.findSlotsByColor(split[1]);
        	System.out.println(findSlotsByColor);
        }else if(line.startsWith("slot_number_for_registration_number")){
        	String[] split = line.split(" ");
        	int slot = checker.findSlotByRegistrationNumber(split[1]);
        	System.out.println(slot!=-100?slot:"Not found");
        }else{
        	System.out.println("not implemented yet");
        }
	}

	public Parker getParker() {
		return parker;
	}

	public Releaser getReleaser() {
		return releaser;
	}

	public Checker getChecker() {
		return checker;
	}
	
}
