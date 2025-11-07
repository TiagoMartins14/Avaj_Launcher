package singletons;

public class WeatherProvider {
	private String[] weather;
	private static WeatherProvider instance;

	private WeatherProvider() {}

	public static WeatherProvider.getInstance() {
		if (instance == NULL) {
			instance = new WeatherProvider();
		}
		return instance;
	}

	public getcurrentWeather(Coordinates p_coordinates) {}
}