package ro.academyplus.avaj.simulator;

public class AircraftFactory {

    public Flyable[]    myFactory;
    private static int  id = 0;

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {

        id++;

        if (p_type.equals("Baloon")) {
            return new Baloon(id, p_name, p_coordinates);
        } else if (p_type.equals("Helicopter")) {
            return new Helicopter(id, p_name, p_coordinates);
        } else if (p_type.equals("JetPlane")) {
            return new JetPlane(id, p_name, p_coordinates);
        } else {
            throw new IllegalArgumentException("Invalid aircraft type: " + p_type);
        }
    }
}
