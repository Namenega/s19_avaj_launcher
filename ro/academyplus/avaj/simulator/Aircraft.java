//package ro.academyplus.avaj.simulator;

public abstract class Aircraft implements Flyable {

    protected long          id;
    protected String        name;
    protected Coordinates    coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {

        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }
}
