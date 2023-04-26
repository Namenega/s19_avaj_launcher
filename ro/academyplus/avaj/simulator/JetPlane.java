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
        String weather = WeatherProvider.getWeatherProvider().getCurrentWeather(super.coordinates);
//        System.out.println(weather);

        switch (weather) {
            case "SUN":
                super.coordinates.setLatitude(super.coordinates.getLatitude() + 10);
                super.coordinates.setHeight(super.coordinates.getHeight() + 2);
                System.out.println("JetPlane#" + super.name + "(" + super.id + "): loves the sun.");
                break;
            case "RAIN":
                super.coordinates.setLatitude(super.coordinates.getLatitude() + 5);
                System.out.println("JetPlane#" + super.name + "(" + super.id + "): loves the rain.");
                break;
            case "FOG":
                super.coordinates.setLatitude(super.coordinates.getLatitude() + 1);
                System.out.println("JetPlane#" + super.name + "(" + super.id + "): loves the fog.");
                break;
            case "SNOW":
                super.coordinates.setHeight(super.coordinates.getHeight() - 7);
                System.out.println("JetPlane#" + super.name + "(" + super.id + "): loves the snow.");
                break;
        }
    }


}
