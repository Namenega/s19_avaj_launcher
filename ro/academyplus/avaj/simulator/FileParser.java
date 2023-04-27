package ro.academyplus.avaj.simulator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

	/**
	 * The function parses aircraft type from a string array and returns a Flyable
	 * object based on the type.
	 * 
	 * @param tokens an array of strings containing the information needed to
	 * create an aircraft object (type, name, longitude, latitude, height)
	 * @param i The parameter "i" is an integer that represents the index of the
	 * current line being processed in a file. It is used to provide context in
	 * case an exception is thrown, to indicate which line caused the error.
	 * @return If the first token in the input array is "Baloon", "Helicopter", or
	 * "JetPlane", a new aircraft object is created using the AircraftFactory class
	 * and the corresponding type of aircraft is returned. If there is a
	 * NumberFormatException, an exception is thrown. If the first token is not one
	 * of the specified aircraft types, null is returned.
	 * @throws MyException
	 */
	public static Flyable parseAircraftType(String[] tokens, int i) throws MyException {

		int longitude = Integer.parseInt(tokens[2]);
		int latitude = Integer.parseInt(tokens[3]);
		int height = Integer.parseInt(tokens[4]);
		AircraftFactory myFactory = new AircraftFactory();

		if (tokens[0].equals("Baloon") || tokens[0].equals("Helicopter") || tokens[0].equals("JetPlane")) {
			Coordinates coord = new Coordinates(longitude, latitude, height);
			return(myFactory.newAircraft(tokens[0], tokens[1], coord));
		}
		return (null);
	}

	/**
	 * This Java function reads aircraft data from a file, validates the data, and
	 * returns a list of flyable objects.
	 * 
	 * @param filename The filename parameter is a String that represents the name
	 * or path of the file that contains the aircraft data to be parsed.
	 * @return The method is returning a List of objects that implement the Flyable
	 * interface.
	 * @throws IOException
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
	 * The function reads a file and parses the first line as an integer, throwing
	 * exceptions for invalid input.
	 * 
	 * @param filename The parameter "filename" is a String that represents the
	 * name or path of the file that contains the input data for the method.
	 * @return The method is returning an integer value, which is the number of
	 * turns parsed from the first line of the file specified by the filename
	 * parameter.
	 * @throws IOException
	 * @throws Exception
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
