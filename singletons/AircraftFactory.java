package singletons;

public class AircraftFactory {
	private static AircraftFactory instance;

	private AircraftFactory() {}

	public static AircraftFactory.getInstance() {
		if (instance == NULL) {
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		if (p_type.equals("Helicopter")) {
			return new Helicopter();
		} else if (p_type.equals("JetPlane")) {

		} else {
			
		}
	}
}