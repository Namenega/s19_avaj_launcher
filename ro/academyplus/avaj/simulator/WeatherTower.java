package ro.academyplus.avaj.simulator;

/**
 * The WeatherTower class extends the Tower class and provides methods to get the
 * current weather and change the weather conditions.
 */
public class WeatherTower extends Tower {

	/**
	 * This function returns the current weather for a given set of coordinates.
	 * 
	 * @param p_coordinates p_coordinates is an object of the class Coordinates that
	 * contains the latitude, longitude, and height of a location. It is used as a
	 * parameter to get the current weather of that location from the WeatherProvider
	 * class.
	 * @return The method `getWeather` is returning a `String` which represents the
	 * current weather at the given coordinates. The weather information is obtained
	 * from the `WeatherProvider` class using the `getCurrentWeather` method.
	 */
	public String getWeather(Coordinates p_coordinates) {
		return WeatherProvider.getWeatherProvider().getCurrentWeather(p_coordinates);
	}

	/**
	 * The function "changeWeather" calls the "conditionsChanged" method.
	 */
	public void changeWeather() {
		conditionsChanged();
	}
}
