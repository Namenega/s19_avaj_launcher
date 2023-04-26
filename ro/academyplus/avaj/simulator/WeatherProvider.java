package ro.academyplus.avaj.simulator;

public class WeatherProvider {

    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

//    public WeatherProvider(Coordinates p_coord) {
//        getCurrentWeather(p_coord);
//    }

    public String getCurrentWeather(Coordinates p_coordinates) {

//        System.out.println("Height : " + p_coordinates.getHeight());
//        System.out.println("Lat : " + p_coordinates.getLatitude());
//        System.out.println("Long : " + p_coordinates.getLongitude());

        int sum = (p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude()) / 4;

//        System.out.println(sum);

        if (sum < 25) {
            return (weather[1]);
        } else if (sum < 50) {
            return (weather[0]);
        } else if (sum < 75) {
            return (weather[2]);
        } else {
            return (weather[3]);
        }
    }

    public static WeatherProvider   getWeatherProvider() {
        WeatherProvider weather = new WeatherProvider();
        return weather;
    }
}
