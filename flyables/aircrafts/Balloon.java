package flyables.aircrafts;

import singletons.OutputFileWriter;
import singletons.WeatherProvider;
import static constants.Constants.*;

import flyables.Aircraft;

public class Balloon extends Aircraft {
	public Balloon(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		WeatherProvider weatherProvider = WeatherProvider.getInstance();
		OutputFileWriter fileWriter = OutputFileWriter.getInstance();
		String preMsg = tag() + ": ";

		String currentWeather = weatherProvider.getCurrentWeather(coordinates);

		if (currentWeather.equals(SUN)) {
			this.coordinates.updateCoordinates(2, 0, 4);
			fileWriter.writeOutput(preMsg + "Oh boy, the sun is blinding me.");
		} else if (currentWeather.equals(RAIN)) {
			this.coordinates.updateCoordinates(0, 0, -5);
			fileWriter.writeOutput(preMsg + "I'm siiiiiiiinging in the raaaaaaain.");
		} else if (currentWeather.equals(FOG)) {
			this.coordinates.updateCoordinates(0, 0, -3);
			fileWriter.writeOutput(preMsg + "Can't see a thing!");
		} else {
			this.coordinates.updateCoordinates(0, 0, -15);
			fileWriter.writeOutput(preMsg + "Brrrrrrrrrrr, I'm freeeeeeezing.");
		}
	}
}