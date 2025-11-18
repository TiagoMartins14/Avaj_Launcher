package singletons;

public class WeatherProvider {
	private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
	private static WeatherProvider instance;

	private WeatherProvider() {}

	public static WeatherProvider.getInstance() {
		if (instance == NULL) {
			instance = new WeatherProvider();
		}
		return instance;
	}

	public getCurrentWeather(Coordinates p_coordinates) {
		int type = (p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()) % 4;

		return weather[type];
	}
}