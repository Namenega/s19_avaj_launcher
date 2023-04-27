package ro.academyplus.avaj.simulator;

/**
 * The Helicopter class extends the Aircraft class and updates its coordinates
 * based on the current weather conditions.
 */
public class Helicopter extends Aircraft {

	// This is a constructor for the Helicopter class that takes in three parameters:
	// a long representing the helicopter's ID, a String representing the helicopter's
	// name, and a Coordinates object representing the helicopter's starting
	// coordinates. The constructor calls the constructor of the superclass (Aircraft)
	// with these parameters using the `super` keyword, which initializes the ID,
	// name, and coordinates of the helicopter.
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	/**
	 * The function updates the helicopter's coordinates and prints a message based
	 * on the current weather conditions.
	 */
	@Override
	public void updateConditions() {

		// String weather = weatherTower.getWeatherProvider().getCurrentWeather(super.coordinates);
		String weather = weatherTower.getWeather(coordinates);

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

	// These are method overrides for the Aircraft class. The `@Override` annotation
	// indicates that these methods are overriding methods from the superclass. The
	// `final` keyword indicates that these methods cannot be overridden by any
	// subclasses of the Helicopter class.
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
