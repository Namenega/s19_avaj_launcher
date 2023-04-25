import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulator {

    private static int  ERROR_ARG = 1;
    private static int  count = 0;

    private static void parseDataLine(String[] splitData) {
        // for (String data : splitData) {
        //     System.out.println(data);
        // }
        if (splitData[0].equals("Baloon")) {
            System.out.println("Baloon ? -> " + splitData[0]);
        } else if (splitData[0].equals("Helicopter")) {
            System.out.println("Helicopter ? -> " + splitData[0]);
        } else if (splitData[0].equals("JetPlane")) {
            System.out.println("JetPlane ? -> " + splitData[0]);
        } else {
            throw new Exception("test");
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
                    int numberOfTurn = Integer.parseInt(splitData[0]);
                    System.out.println(numberOfTurn);
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
			e.printStackTrace();
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
