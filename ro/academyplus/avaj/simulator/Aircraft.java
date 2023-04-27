package ro.academyplus.avaj.simulator;

/**
 * The abstract class Aircraft extends Flyable and contains properties and methods
 * related to aircrafts.
 */
public abstract class Aircraft extends Flyable {

	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {

		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}
}
