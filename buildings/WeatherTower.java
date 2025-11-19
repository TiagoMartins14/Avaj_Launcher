package buildings;

import flyables.aircrafts.Coordinates;
import singletons.WeatherProvider;

public class WeatherTower extends Tower{
	public String getWeather(Coordinates p_coordinates) {
		WeatherProvider weatherProvider = WeatherProvider.getInstance();

		String currentWeather = weatherProvider.getCurrentWeather(p_coordinates);

		return currentWeather;
	}

	public void changeWeather() {
		conditionChanged();
	}
}