package ro.academyplus.avaj.simulator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The FileParser class reads and parses aircraft data from a file, validates the
 * data, and returns a list of flyable objects.
 */
public class FileParser {

	/**
	 * The function parses aircraft type from a string array and creates an aircraft
	 * object with given coordinates, throwing an exception if the coordinates are
	 * negative.
	 * 
	 * @param tokens an array of strings containing the information needed to create
	 * an aircraft object, such as its type, name, longitude, latitude, and height.
	 * @param i The parameter "i" is not used in the given code snippet and therefore
	 * has no significance in this context. It is just a placeholder variable in the
	 * method signature.
	 * @return The method is returning an object of type Flyable, which is created
	 * using the AircraftFactory based on the input tokens. If the input tokens do not
	 * match any of the supported aircraft types, the method returns null.
	 */
	public static Flyable parseAircraftType(String[] tokens, int i) throws MyException {

		int longitude = Integer.parseInt(tokens[2]);
		if (longitude < 0) {
			throw new MyException("Aircraft longitude is smaller than 0.");
		}

		int latitude = Integer.parseInt(tokens[3]);
		if (latitude < 0) {
			throw new MyException("Aircraft latitude is smaller than 0.");
		}

		int height = Integer.parseInt(tokens[4]);
		if (height < 0) {
			throw new MyException("Aircraft height is smaller than 0.");
		}

		AircraftFactory myFactory = new AircraftFactory();

		if (tokens[0].equals("Baloon") || tokens[0].equals("Helicopter") || tokens[0].equals("JetPlane")) {
			Coordinates coord = new Coordinates(longitude, latitude, height);
			return(myFactory.newAircraft(tokens[0], tokens[1], coord));
		}
		return (null);
	}

	/**
	 * The function reads data from a file, parses it, and creates a list of flyable
	 * objects.
	 * 
	 * @param filename The filename parameter is a String that represents the name or
	 * path of the file that contains the aircraft data to be parsed.
	 * @return The method is returning a List of objects that implement the Flyable
	 * interface.
	 */
	public static List<Flyable> parseAircraftData(String filename) throws MyException, IOException {

		List<String> lines = Files.readAllLines(Paths.get(filename));
		List<Flyable> flyableArr = new ArrayList<Flyable>();

		for (int i = 1; i < lines.size(); i++) {
			String[] tokens = lines.get(i).split(" ");

			if (tokens.length != 5) {
				throw new MyException("FileError: Line " + (i + 1) + ": has not 5 tokens");
			}

			flyableArr.add(parseAircraftType(tokens, i));
		}
		return flyableArr;
	}

	/**
	 * The function reads a file and parses the first line to return an integer
	 * representing the number of turns.
	 * 
	 * @param filename The name of the file that contains the input data.
	 * @return The method is returning an integer value, which is the first line of
	 * the file after parsing it.
	 */
	public static int parseTurns(String filename) throws MyException, IOException {
		List<String> lines = Files.readAllLines(Paths.get(filename));

		if (lines.isEmpty()) {
			throw new MyException(filename + " is empty.");
		}
		for (int i = 0; i < lines.size(); i++) {
			String[] tokens = lines.get(i).split(" ");
			
			if (tokens.length == 1) {
				if (i != 0) {
					throw new MyException("Error: Line " + (i + 1) + ": Only one token.");
				}
			} else if (i == 0) {
				throw new MyException("Error: Line " + (i + 1) + ": Wrong token.");
			}
		}
		return Integer.parseInt(lines.get(0));
	}
}
