package ro.academyplus.avaj.simulator;

public class Coordinates {

	private int longitude;
	private int latitude;
	private int height;

	// This is a constructor for the `Coordinates` class that takes in three integer
	// parameters: `p_longitude`, `p_latitude`, and `p_height`. It initializes the
	// private variables `longitude`, `latitude`, and `height` with the values of the
	// corresponding parameters using the `this` keyword to refer to the instance
	// variables.
	Coordinates(int p_longitude, int p_latitude, int p_height) {

		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = p_height;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getHeight() {
		return height;
	}
}
