package ro.academyplus.avaj.simulator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Simulator {

	private static final int	ERROR_ARG = 1;
	private static final int	ERROR_FILE = 2;

	private static int				turns;
	private static List<Flyable>	fleet = new ArrayList<Flyable>();
	private static WeatherTower		wt = new WeatherTower();

	public static void run() {

		for (Flyable aircraft : fleet) {
			
			// Tower.getTower().register(aircraft);
			wt.register(aircraft);
		}
		System.out.print("\n");

		for (int i = turns; i > 0; i--) {

			wt.changeWeather();
		}
	}

	/**
	 * The function parses a file to retrieve the number of turns and aircraft
	 * data.
	 * 
	 * @param filename The filename parameter is a string that represents the name
	 * of the file that needs to be parsed. This method is responsible for parsing
	 * the file and extracting information about the number of turns and aircraft
	 * data.
	 * @throws IOException
	 * @throws Exception
	 */
	public static void parsing(String filename) throws MyException, IOException {

		// get the number of turns
		try {
			turns = FileParser.parseTurns(filename);

		} catch (MyException | NumberFormatException e) {
			// System.out.println(e.getMessage());
			throw new MyException(e.getMessage());
			// System.exit(ERROR_FILE);
		}
		
		// get info on other lines
		try {
			fleet = FileParser.parseAircraftData(filename);
		} catch (MyException | NumberFormatException e) {
			// System.out.println(e.getMessage());
			// System.exit(ERROR_FILE);
			throw new MyException(e.getMessage());
		}
	}
		
	/**
	 * The main function checks the number of arguments and calls the parsing and
	 * run functions.
	 */
	public static void main(String[] args) {
		
		// This code block is checking the number of arguments passed to the main
		// function. If the number of arguments is not equal to 1, it prints an error
		// message and exits the program with an error code of 1.
		if (args.length != 1) {
			System.out.println("ArgError: wrong number of arguments");
			System.out.println("Usage: java ro.academyplus.avaj.simulator <scenario.txt>");
			System.exit(ERROR_ARG);
		}
		
		try {
			PrintStream out = new PrintStream(new FileOutputStream("simulation.txt"));
			System.setOut(out);
			parsing(args[0]);
			run();
			// out.close();
		} catch (MyException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
