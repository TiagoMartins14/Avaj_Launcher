package simulator;

import buildings.*;
import flyables.*;
import flyables.aircrafts.Coordinates;
import singletons.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Simulator {
	private long numberOfSimulations;
	private WeatherTower weatherTower = new WeatherTower();
	private AircraftFactory aircraftFactory = AircraftFactory.getInstance();

	private void runSimulator(File scenario) {
		Validator myValidator = new Validator(scenario);
		
		if (myValidator.isValidFile()) {

			try {
        		new FileWriter("simulation.txt", false).close();
    		} catch (IOException e) {
       			System.out.println("Could not reset simulation.txt");
    		}

			try (Scanner scanner = new Scanner(scenario)) {
				// Get number of simulations
				numberOfSimulations = Integer.parseInt(scanner.nextLine().trim());

				// Get number of aicrafts
				while (scanner.hasNextLine()) {
					String[] aircraftParams =  scanner.nextLine().trim().split("\\s+");

					String type = aircraftParams[0];
					String name = aircraftParams [1];
					int lon = Integer.parseInt(aircraftParams[2]);
					int lat = Integer.parseInt(aircraftParams[3]);
					int height = Integer.parseInt(aircraftParams[4]);

					Coordinates coordinates = new Coordinates(lon, lat, height);
					Flyable newAircraft = aircraftFactory.newAircraft(type, name, coordinates);

					// aircrafts.add(newAircraft);
					newAircraft.registerTower(weatherTower);
				}
				
				// Run sim <numberOfSimulations> times
				for (long i = 0; i < numberOfSimulations; i++) {
					weatherTower.changeWeather();
				}
			
			} catch (FileNotFoundException e) {
				System.out.println("File not found: " + scenario.getName());
			}
		} 
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			return;
		}
		

		final File scenario = new File(args[0]);

		final Simulator simulator = new Simulator();

		simulator.runSimulator(scenario);
	}
}