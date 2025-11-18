package buildings;

public class WeatherTower extends Tower{
	public String getWeather(Coordinates p_coordinates) {
		WeatherProvider weatherProvider = WeatherProvider.getInstance();

		String currentWeather = weatherProvider.getCurrentWeather();

		return currentWeather;
	}

	public void changeWeather() {}
}