package simulator;

import java.io.File;
import java.util.Scanner;

import static constants.Constants.*;

public class Validator {

    private File file;

    public Validator(File file) {
        this.file = file;
    }

    public boolean isValidFile() {

        if (!file.exists() || !file.isFile() || !file.getName().toLowerCase().endsWith(".txt")) {
            System.out.println("Invalid file or file type.");
            return false;
        }

        try (Scanner scanner = new Scanner(file)) {
            if (!scanner.hasNextLine()) {
                System.out.println("File is empty.");
                return false;
            }
            String firstLine = scanner.nextLine().trim();
            if (!isPositiveLong(firstLine)) {
                return false;
            }
            while (scanner.hasNextLine()) {
                String[] params = scanner.nextLine().trim().split("\\s+");
                if (params.length != EXPECTED_PARAMS ||
                    (!params[0].equals(BALLOON) &&
                     !params[0].equals(HELICOPTER) &&
                     !params[0].equals(JETPLANE))) {
                    System.out.println("Incorrect file parameter(s).");
                    return false;
                }

                try {
                    int lon = Integer.parseInt(params[2]);
                    int lat = Integer.parseInt(params[3]);
                    int height = Integer.parseInt(params[4]);
                    if (lon < 0 || lat < 0 || height < 0 || height > MAX_HEIGHT) {
                        System.out.println("Incorrect file parameter(s).");
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
            return false;
        }

        return true;
    }

    private boolean isPositiveLong(String str) {
        try {
            return Long.parseLong(str) > 0;
        } catch (NumberFormatException e) {
			System.out.println("Incorrect file parameter(s).");
            return false;
        }
    }
}
