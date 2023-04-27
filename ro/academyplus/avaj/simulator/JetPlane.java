package ro.academyplus.avaj.simulator;

/**
 * The JetPlane class extends the Aircraft class and updates its conditions based
 * on the current weather.
 */
public class JetPlane extends Aircraft {

	public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	/**
	 * The function updates the conditions of a JetPlane based on the current
	 * weather and prints a corresponding message.
	 */
	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);

		switch (weather) {
			case "SUN":
				super.coordinates.setLatitude(super.coordinates.getLatitude() + 10);
				super.coordinates.setHeight(super.coordinates.getHeight() + 2);
				System.out.println("JetPlane#" + super.name + "(" + super.id + "): I love the sun 🥵 .");
				break;
			case "RAIN":
				super.coordinates.setLatitude(super.coordinates.getLatitude() + 5);
				System.out.println("JetPlane#" + super.name + "(" + super.id + "): I love the rain ⛈ .");
				break;
			case "FOG":
				super.coordinates.setLatitude(super.coordinates.getLatitude() + 1);
				System.out.println("JetPlane#" + super.name + "(" + super.id + "): I love the fog 🌁 .");
				break;
			case "SNOW":
				super.coordinates.setHeight(super.coordinates.getHeight() - 7);
				System.out.println("JetPlane#" + super.name + "(" + super.id + "): I love the snow ⛄️ .");
				break;
		}
	}

	// These are method overrides for the Aircraft class. They are used to provide
	// specific implementations for the getId(), getName(), getType(), and getHeight()
	// methods for the JetPlane class. The @Override annotation indicates that these
	// methods are overriding methods from the superclass. The final keyword indicates
	// that these methods cannot be overridden by any subclasses of JetPlane.
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
		return "JetPlane";
	}

	@Override
	public final int	getHeight() {
		return this.coordinates.getHeight();
	}
}
