package aircrafts;

public class Helicopter extends Aircraft (
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@override
	public void updateConditions() {
		WeatherProvider weatherProvider = WeatherProvider.getInstance();

		String currentWeather = weatherProvider.getcurrentWeather();

		if (currentWeather.equals(SUN)) {
			this.coordinates.updateCoordinates(10, 0, 2);
			System.out.println("Oh boy, the sun ins blinding me.")
		} else if (currentWeather.equals(RAIN)) {
			this.coordinates.updateCoordinates(5, 0, 0);
			System.out.println("I'm siiiiiiiinging in the raaaaaaain.")
		} else if (currentWeather.equals(FOG)) {
			this.coordinates.updateCoordinates(1, 0, 0);
			System.out.println("Can't see a thing!")
		} else {
			this.coordinates.updateCoordinates(0, 0, -12);
			System.out.println("Brrrrrrrrrrr, I'm freeeeeeezing.")
		}
	}
)