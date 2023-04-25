package ro.academyplus.avaj.simulator;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {

        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions() {

    }

	@Override
	public void registerTower(WeatherTower[] p_tower) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'registerTower'");
	}
}
