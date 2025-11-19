package singletons;

import static constants.Constants.*;

import flyables.aircrafts.Coordinates;

public class WeatherProvider {
	private String[] weather = {RAIN, FOG, SUN, SNOW};
	private static WeatherProvider instance;

	private WeatherProvider() {}

	public static WeatherProvider getInstance() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}

	public String getCurrentWeather(Coordinates p_coordinates) {
		int type = (p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()) % 4;

		return weather[type];
	}
}