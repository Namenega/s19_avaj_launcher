package ro.academyplus.avaj.simulator;

/**
 * The `AircraftFactory` class creates new aircraft objects based on the given
 * type, name, and coordinates.
 */
public class AircraftFactory {

	public Flyable[]	myFactory;
	private static int	id = 0;

	/**
	 * The function creates a new aircraft object based on the given type, name,
	 * and coordinates.
	 * 
	 * @param p_type a String representing the type of aircraft (either "Baloon",
	 * "Helicopter", or "JetPlane")
	 * @param p_name The name of the aircraft being created.
	 * @param p_coordinates p_coordinates is an object of the Coordinates class
	 * that represents the current coordinates of the aircraft. It contains three
	 * parameters: longitude, latitude, and height.
	 * @return The method `newAircraft` returns an object that implements the
	 * `Flyable` interface. The specific type of object returned depends on the
	 * value of the `p_type` parameter.
	 * @throws MyException
	 */
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws MyException {

		id++;

		if (p_type.equals("Baloon")) {
			return new Baloon(id, p_name, p_coordinates);
		} else if (p_type.equals("Helicopter")) {
			return new Helicopter(id, p_name, p_coordinates);
		} else if (p_type.equals("JetPlane")) {
			return new JetPlane(id, p_name, p_coordinates);
		} else {
			throw new MyException("Invalid aircraft type: " + p_type);
		}
	}
}
