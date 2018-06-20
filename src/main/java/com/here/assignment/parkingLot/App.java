package com.here.assignment.parkingLot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class App {
	public static void main(String[] args) {
		ExecutionerFacade facade = new ExecutionerFacade();
		try {
			if (args.length == 0) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				String line = null;
				while (!(line = bufferedReader.readLine()).equals("exit")) {
					facade.executeCommand(line);
				}
				bufferedReader.close();
			} else {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					facade.executeCommand(line);
				}
				bufferedReader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
