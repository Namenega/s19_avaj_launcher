package ro.academyplus.avaj.simulator;

/**
 * The Helicopter class extends the Aircraft class and updates its coordinates
 * based on the current weather conditions.
 */
public class Helicopter extends Aircraft {

	public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {

		super(p_id, p_name, p_coordinate);
	}

	/**
	 * The function updates the helicopter's coordinates and prints a message based
	 * on the current weather conditions.
	 */
	@Override
	public void updateConditions() {

		String weather = WeatherProvider.getWeatherProvider().getCurrentWeather(super.coordinates);
//		System.out.println(weather);

		switch (weather) {
			case "SUN":
				super.coordinates.setLongitude(super.coordinates.getLongitude() + 10);
				super.coordinates.setHeight(super.coordinates.getHeight() + 2);
				System.out.println("Helicopter#" + super.name + "(" + super.id + "): I love the sun 🥵 .");
				break;
			case "RAIN":
				super.coordinates.setLongitude(super.coordinates.getLongitude() + 5);
				System.out.println("Helicopter#" + super.name + "(" + super.id + "): I love the rain ⛈ .");
				break;
			case "FOG":
				super.coordinates.setLongitude(super.coordinates.getLongitude() + 1);
				System.out.println("Helicopter#" + super.name + "(" + super.id + "): I love the fog 🌁 .");
				break;
			case "SNOW":
				super.coordinates.setHeight(super.coordinates.getHeight() - 12);
				System.out.println("Helicopter#" + super.name + "(" + super.id + "): I love the snow ⛄️ .");
				break;
		}
	}

	@Override
	public final long	getId() {
		return this.id;
	}
	
	@Override
	public final String	getName() {
		return this.name;
	}
	
	@Override
	public final String	getType() {
		return "Helicopter";
	}

	@Override
	public final int	getHeight() {
		return this.coordinates.getHeight();
	}
}
