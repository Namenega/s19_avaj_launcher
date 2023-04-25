package ro.academyplus.avaj.simulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Simulator {

	private static int				ERROR_ARG = 1;
	private static int				ERROR_PARSE = 2;
	private static int				count = 0;
	private static int				numberOfTurn;
	private static AircraftFactory	myFactory;

	private static void parseDataLine(String[] data) {
		try {
			int		longitude = Integer.parseInt(data[2]);
			int		latitude = Integer.parseInt(data[3]);
			int		height = Integer.parseInt(data[4]);
			String	type = data[0];
			String	name = data[1];

			if (type.equals("Baloon") || type.equals("Helicopter") || type.equals("JetPlane")) {
				Coordinates coord = new Coordinates(longitude, latitude, height);
				myFactory.newAircraft(type, name, coord);
			} else {
				throw new Exception("1st parameter is broken.");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void parsing(String data) {
		try {
			String splitData[] = data.split(" ");

			if (splitData.length == 1) {
				count += 1;
				if (count > 1) {
					throw new Exception("Many 'number of turns' line.");
				}
				try {
					numberOfTurn = Integer.parseInt(splitData[0]);
					// System.out.println(numberOfTurn);
				} catch (NumberFormatException e) {
					throw new NumberFormatException();
				}
			} else if (splitData.length == 5) {
				try {
					parseDataLine(splitData);
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			} else {
				throw new Exception("This line should not be in the file.");
			}

			
		} catch (Exception e) {
			System.out.println("An error occured.");
			System.out.println(e.getMessage());
			System.exit(ERROR_PARSE);
		}
	}

	public static void main(String[] args) {


		if (args.length != 1) {
			System.out.println("Error: wrong number of arguments");
			System.out.println("Usage: java ro.academyplus.avaj.simulator <scenario.txt>");
			System.exit(ERROR_ARG);
		}

		//get the file in argument
		File scenario = new File(args[0]);

		try {
			Scanner scan = new Scanner(scenario);

			if (!scan.hasNext()) {
				scan.close();
				throw new Exception("File is empty.");
			}
			
			while (scan.hasNextLine()) {
				String data = scan.nextLine();
				// System.out.println("hey: " + data);
				parsing(data);
			}

			scan.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
