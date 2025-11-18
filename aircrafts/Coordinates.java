package aircrafts;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this. height = p_height;
	}

	// Getters
	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getHeight() {
		return height;
	}

	// Setters
	private setLongitude(int value) {
		p_longitude += value;
	}

	private setLatitude(int value) {
		p_latitude += value;
	}

	private setHeight(int value) {
		p_height += value;

		if (height > 100) {
			height = 100;
		}
	}

	public updateCoordinates(int longitude, int latitude, int height) {
		this.setLongitude(longitude);
		this.setLatitude(latitude);
		this.setHeight(height);
	}
}