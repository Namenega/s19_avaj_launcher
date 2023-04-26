package ro.academyplus.avaj.simulator;

/**
 * The Coordinates class represents a set of coordinates with longitude, latitude,
 * and height attributes, and includes methods to get and set these attributes.
 */
public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

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
