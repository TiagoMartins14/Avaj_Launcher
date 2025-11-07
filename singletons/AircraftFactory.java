package singletons;

public class AircraftFactory {
	private static AircraftFactory instance;

	private AircraftFactory() {
		if (instance == NULL) {
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {}
}