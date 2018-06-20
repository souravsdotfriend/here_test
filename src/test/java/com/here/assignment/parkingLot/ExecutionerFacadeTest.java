package com.here.assignment.parkingLot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ExecutionerFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParkWithOutCreatingPL() {
		ExecutionerFacade facade = new ExecutionerFacade();
//		gracefully fail.
		facade.executeCommand("park KA-01-HH-1234 White");
		Assert.assertEquals(facade.getParker(), null);
	}
	
	@Test
	public void testReleaseWithOutCreatingPL() {
		ExecutionerFacade facade = new ExecutionerFacade();
//		gracefully fail.
		facade.executeCommand("leave 4");
		Assert.assertEquals(facade.getParker(), null);
	}
	
	@Test
	public void testStatusWithOutCreatingPL() {
		ExecutionerFacade facade = new ExecutionerFacade();
		facade.executeCommand("status");
		Assert.assertEquals(facade.getChecker(), null);
	}
	
	@Test
	public void testParkAfterCreatingPL() {
		ExecutionerFacade facade = new ExecutionerFacade();
		facade.executeCommand("create_parking_lot 6");
		facade.executeCommand("park KA-01-HH-1234 White");
		Assert.assertNotNull(facade.getParker());
	}
	
	@Test
	public void testLeaveAfterCreatingPL() {
		ExecutionerFacade facade = new ExecutionerFacade();
		facade.executeCommand("create_parking_lot 6");
		facade.executeCommand("park KA-01-HH-1234 White");
		facade.executeCommand("leave 1");
		facade.executeCommand("leave 1");
		Assert.assertNotNull(facade.getReleaser());
	}
	@Test
	public void testStatusAfterCreatingPL() {
		ExecutionerFacade facade = new ExecutionerFacade();
		facade.executeCommand("create_parking_lot 6");
		facade.executeCommand("park KA-01-HH-1234 White");
		facade.executeCommand("status");
		Assert.assertNotNull(facade.getChecker());
	}

	@Test
	public void testsearch1AfterCreatingPL() {
		ExecutionerFacade facade = new ExecutionerFacade();
		facade.executeCommand("create_parking_lot 6");
		facade.executeCommand("park KA-01-HH-1234 White");
		facade.executeCommand("registration_numbers_for_cars_with_colour white");
		Assert.assertNotNull(facade.getChecker());
	}

	@Test
	public void testsearch2AfterCreatingPL() {
		ExecutionerFacade facade = new ExecutionerFacade();
		facade.executeCommand("create_parking_lot 6");
		facade.executeCommand("park KA-01-HH-1234 White");
		facade.executeCommand("slot_numbers_for_cars_with_colour white");
		Assert.assertNotNull(facade.getChecker());
	}
	@Test
	public void testsearch3AfterCreatingPL() {
		ExecutionerFacade facade = new ExecutionerFacade();
		facade.executeCommand("create_parking_lot 6");
		facade.executeCommand("park KA-01-HH-1234 White");
		facade.executeCommand("slot_number_for_registration_number KA-01-HH-3141");
		Assert.assertNotNull(facade.getChecker());
	}
}
