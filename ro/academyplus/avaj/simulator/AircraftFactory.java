package ro.academyplus.avaj.simulator;

public class AircraftFactory {

	public Flyable[]	myFactory;

	private static int	c_baloon = 1;
	private static int	c_helicopter = 1;
	private static int	c_jetplane = 1;

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		
		if (p_type.equals("Baloon")) {
			c_baloon++;
			return new Baloon(c_baloon, p_name, p_coordinates);

		} else if (p_type.equals("Helicopter")) {
			Helicopter b = new Helicopter(c_helicopter, p_name, p_coordinates);
			c_helicopter++;
		}
		if (p_type.equals("JetPlane")) {
			JetPlane b = new JetPlane(c_jetplane, p_name, p_coordinates);
			c_jetplane++;
		}
	}
}
