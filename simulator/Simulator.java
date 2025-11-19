package simulator;

import static constants.Constants.*;
import buildings.*;
import flyables.*;
import singletons.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulator {
	public static void main(String[] args) {
		if (args.length != 1) {
			return;
		}

		String fileName = args[0];
		File scenario = new File(fileName);

		try (Scanner myReader = new Scanner(scenario)) {
			if (isFirstLineGood(myReader) && areRemainingLinesGood(myReader)) {
				//
			} else {
				System.out.println("File incorrectly formatted.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		}
	}

	private static boolean isFirstLineGood(Scanner myReader) {
		if (!myReader.hasNextLine()) {
			System.out.println("File is empty.");
			return false;
		}

		String data = myReader.nextLine().trim();

		if (!isPositiveLong(data)) {
			System.out.println("Incorrect file parameter(s).");
			return false;
		}

		return true;
	}

	private static boolean areRemainingLinesGood(Scanner myReader) {
		while (myReader.hasNextLine()) {
			String line = myReader.nextLine().trim();
			String[] params = line.split("\\s+");

			if (params.length != 5) {
				return false;
			}

			if (!params[0].equals(BALLOON) &&
				!params[0].equals(HELICOPTER) &&
				!params[0].equals(JETPLANE)) {
				return false;
			}

			int lon, lat, height;
			try {
				lon = Integer.parseInt(params[2]);
				lat = Integer.parseInt(params[3]);
				height = Integer.parseInt(params[4]);
			} catch (NumberFormatException e) {
				return false;
			}

			if (lon < 0 || lat < 0 || height < 0 || height > 100) {
				return false;
			}
		}

		return true;
	}

	private static boolean isPositiveLong(String str) {
		try {
			long value = Long.parseLong(str);
			return value > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}