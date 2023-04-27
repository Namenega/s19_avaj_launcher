package ro.academyplus.avaj.simulator;

/**
 * The WeatherProvider class generates the current weather based on the coordinates
 * provided.
 */
public class WeatherProvider {

	private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {}

	/**
	 * The function returns the current weather based on the average of the given
	 * coordinates.
	 * 
	 * @param p_coordinates The parameter p_coordinates is an object of the class
	 * Coordinates, which contains information about the latitude, longitude, and
	 * height of a location.
	 * @return The method is returning a String value which represents the current
	 * weather based on the average of the coordinates provided. The returned value
	 * is one of the elements of the "weather" array, which could be "Sunny",
	 * "Cloudy", "Rainy", or "Snowy".
	 */
	public String getCurrentWeather(Coordinates p_coordinates) {

		int sum = (p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude()) / 4;

		if (sum < 25) {
			return (weather[1]);
		} else if (sum < 50) {
			return (weather[0]);
		} else if (sum < 75) {
			return (weather[2]);
		} else {
			return (weather[3]);
		}
	}

	public static WeatherProvider	getWeatherProvider() {
		WeatherProvider weather = new WeatherProvider();
		return weather;
	}
}
