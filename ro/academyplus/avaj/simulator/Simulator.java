package ro.academyplus.avaj.simulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulator {

    private static final int    ERROR_ARG = 1;
    private static final int    ERROR_FILE = 2;

    private static int                      turns;
    private static List<Flyable> fleet = new ArrayList<Flyable>();

    public static void run() {
        for (int i = turns; i > 0; i--) {
            for (Flyable aircraft : fleet) {
                aircraft.updateConditions();
            }
        }
    }

    public static void parsing(String filename) {

        // get the number of turns
        try {
            turns = FileParser.parseTurns(filename);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(ERROR_FILE);
        }

        // get info on other lines
        try {
            fleet = FileParser.parseAircraftData(filename);
            run();
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(ERROR_FILE);
        }
    }

    public static void main(String[] args) {

        //Checking argument number
        if (args.length != 1) {
            System.out.println("ArgError: wrong number of arguments");
            System.out.println("Usage: java ro.academyplus.avaj.simulator <scenario.txt>");
            System.exit(ERROR_ARG);
        }

        // Parsing all file
        parsing(args[0]);
    }
}
