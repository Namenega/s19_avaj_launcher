package ro.academyplus.avaj.simulator;

/**
 * The Coordinates class represents a set of coordinates with longitude, latitude,
 * and height attributes, and includes methods to get and set these attributes.
 */
public class Coordinates {

	private int longitude;
	private int latitude;
	private int height;

	// This is a constructor for the Coordinates class that takes in three integer
	// parameters representing longitude, latitude, and height, and initializes the
	// corresponding instance variables with these values.
	Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = p_height;
	}

	// These are getter methods for the `longitude`, `latitude`, and `height` instance
	// variables of the `Coordinates` class. They allow other classes to access the
	// values of these variables without directly modifying them.
	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getHeight() {
		return height;
	}

	// These are setter methods for the `longitude`, `latitude`, and `height` instance
	// variables of the `Coordinates` class. They allow other classes to modify the
	// values of these variables indirectly by passing in new values as parameters.
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public void setHeight(int height) {
		this.height = height > 100 ? 100 : height;
	}
}
