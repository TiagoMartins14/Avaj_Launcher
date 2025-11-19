package flyables.aircrafts;

import flyables.Aircraft;
import singletons.OutputFileWriter;
import singletons.WeatherProvider;
import static constants.Constants.*;

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		WeatherProvider weatherProvider = WeatherProvider.getInstance();
		OutputFileWriter fileWriter = OutputFileWriter.getInstance();
		String preMsg = tag() + ": ";

		String currentWeather = weatherProvider.getCurrentWeather(coordinates);

		if (currentWeather.equals(SUN)) {
			this.coordinates.updateCoordinates(0, 10, 2);
			fileWriter.writeOutput(preMsg + "Oh boy, the sun is blinding me.");
		} else if (currentWeather.equals(RAIN)) {
			this.coordinates.updateCoordinates(0, 5, 0);
			fileWriter.writeOutput(preMsg + "I'm siiiiiiiinging in the raaaaaaain.");
		} else if (currentWeather.equals(FOG)) {
			this.coordinates.updateCoordinates(0, 1, 0);
			fileWriter.writeOutput(preMsg + "Can't see a thing!");
		} else {
			this.coordinates.updateCoordinates(0, 0, -7);
			fileWriter.writeOutput(preMsg + "Brrrrrrrrrrr, I'm freeeeeeezing.");
		}
	}
}