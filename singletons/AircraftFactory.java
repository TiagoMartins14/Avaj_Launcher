package singletons;

import flyables.Flyable;
import flyables.aircrafts.*;
import static constants.Constants.*;

public class AircraftFactory {
	private static AircraftFactory instance;
	private long id = 0;

	private AircraftFactory() {}

	public static AircraftFactory getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		id++;

		if (p_type.equals(HELICOPTER)) {
			return new Helicopter(id, p_name, p_coordinates);
		} else if (p_type.equals(JETPLANE)) {
			return new JetPlane(id, p_name, p_coordinates);
		} else {
			return new Balloon(id, p_name, p_coordinates);
		}
	}
}