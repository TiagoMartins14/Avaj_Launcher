package aircrafts;

public class Balloons extends Aircraft {
	public Balloon(long p_id, String p_name, Coordnates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@override
	public void updateConditions() {
		WeatherProvider weatherProvider = WeatherProvider.getInstance();

		String currentWeather = weatherProvider.getcurrentWeather();

		if (currentWeather.equals(SUN)) {
			this.coordinates.updateCoordinates(2, 0, 4);
			System.out.println("Oh boy, the sun ins blinding me.")
		} else if (currentWeather.equals(RAIN)) {
			this.coordinates.updateCoordinates(0, 0, -5);
			System.out.println("I'm siiiiiiiinging in the raaaaaaain.")
		} else if (currentWeather.equals(FOG)) {
			this.coordinates.updateCoordinates(0, 0, -3);
			System.out.println("Can't see a thing!")
		} else {
			this.coordinates.updateCoordinates(0, 0, -15);
			System.out.println("Brrrrrrrrrrr, I'm freeeeeeezing.")
		}
	}
}