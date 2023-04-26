package ro.academyplus.avaj.simulator;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {

        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        String weather = WeatherProvider.getWeatherProvider().getCurrentWeather(super.coordinates);
//        System.out.println(weather);

        switch (weather) {
            case "SUN":
                super.coordinates.setLongitude(super.coordinates.getLongitude() + 2);
                super.coordinates.setHeight(super.coordinates.getHeight() + 4);
                System.out.println("Baloon#" + super.name + "(" + super.id + "): loves the sun.");
                break;
            case "RAIN":
                super.coordinates.setHeight(super.coordinates.getHeight() - 5);
                System.out.println("Baloon#" + super.name + "(" + super.id + "): loves the rain.");
                break;
            case "FOG":
                super.coordinates.setHeight(super.coordinates.getHeight() - 3);
                System.out.println("Baloon#" + super.name + "(" + super.id + "): loves the fog.");
                break;
            case "SNOW":
                super.coordinates.setHeight(super.coordinates.getHeight() - 15);
                System.out.println("Baloon#" + super.name + "(" + super.id + "): loves the snow.");
                break;
        }
    }

//    @Override
//    public void registerTower(WeatherTower[] p_tower) {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'registerTower'");
//    }
}
