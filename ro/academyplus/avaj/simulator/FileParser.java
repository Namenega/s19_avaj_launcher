package ro.academyplus.avaj.simulator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    public static int parseTurns(String filename) throws IOException, IllegalArgumentException {
        List<String> lines = Files.readAllLines(Paths.get(filename));

        for (int i = 0; i < lines.size(); i++) {
            String[] tokens = lines.get(i).split(" ");

            if (tokens.length == 1) {
                if (i != 0) {
                    throw new IllegalArgumentException("Error: Line " + (i + 1) + ": Only one token.");
                }
            } else if (i == 0) {
                throw new IllegalArgumentException("Error: Line " + (i + 1) + ": Wrong token.");
            }
        }

        try {
            return Integer.parseInt(lines.get(0));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error: Line 1: Not a number.");
        }
    }

    public static Flyable parseAircraftType(String[] tokens, int i) {

        try {
            int longitude = Integer.parseInt(tokens[2]);
            int latitude = Integer.parseInt(tokens[3]);
            int height = Integer.parseInt(tokens[4]);
            AircraftFactory myFactory = new AircraftFactory();

            if (tokens[0].equals("Baloon") || tokens[0].equals("Helicopter") || tokens[0].equals("JetPlane")) {
                Coordinates coord = new Coordinates(longitude, latitude, height);
                return(myFactory.newAircraft(tokens[0], tokens[1], coord));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("FileError: Line " +  (i + 1) + ": A token is not a number," +
                    " but should be.");
        }
        return (null);
    }

    public static List<Flyable> parseAircraftData(String filename) throws IOException, IllegalArgumentException {

        List<String> lines = Files.readAllLines(Paths.get(filename));
        List<Flyable> flyableArr = new ArrayList<Flyable>();

        for (int i = 1; i < lines.size(); i++) {
            String[] tokens = lines.get(i).split(" ");

            if (tokens.length != 5) {
                throw new IllegalArgumentException("FileError: Line " + (i + 1) + ": has not 5 tokens");
            }

            flyableArr.add(parseAircraftType(tokens, i));
        }
        return flyableArr;
    }
}
