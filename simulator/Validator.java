package simulator;

import java.io.File;
import java.util.Scanner;

import exceptions.InvalidAircraftFormatException;
import exceptions.InvalidAircraftTypeException;
import exceptions.InvalidSimulationRunsException;
import exceptions.MissingAircraftException;

import static constants.Constants.*;

public class Validator {

    private File file;

    public Validator(File file) {
        this.file = file;
    }

    public boolean isValidFile() {

        if (!file.exists() || !file.isFile() || !file.getName().toLowerCase().endsWith(".txt")) {
            System.out.println("Invalid file or file type: " + file.getName() + ".");
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

            if (!scanner.hasNextLine()) {
                throw new MissingAircraftException("No aircrafts detected.");
            }
            while (scanner.hasNextLine()) {
                String[] params = scanner.nextLine().trim().split("\\s+");
                if (params.length != EXPECTED_PARAMS) {
                    throw new InvalidAircraftFormatException("Invalid aircraft format. Expected 5 parameters.");
                }
                if (params.length != EXPECTED_PARAMS ||
                    (!params[0].equals(BALLOON) &&
                     !params[0].equals(HELICOPTER) &&
                     !params[0].equals(JETPLANE))) {
                    throw new InvalidAircraftTypeException("Invalid aircraft type: " + params[0] + ".");
                }

                 try {
                    int lon = Integer.parseInt(params[2]);
                    int lat = Integer.parseInt(params[3]);
                    int height = Integer.parseInt(params[4]);
                    if (lon < 0 || lat < 0 || height < 0 || height > MAX_HEIGHT) {
                        throw new InvalidAircraftFormatException("Coordinate out of bounds. Longitude: " + lon + ", latitude: " + lat + ", height: " + height + ".");
                    }
                } catch (NumberFormatException e) {
                    throw new InvalidAircraftFormatException("Invalid coordinate type found. Coordinates must be integers.");
                }
            }
        } catch (InvalidSimulationRunsException e) {
            System.out.println(e.getMessage());
            return false;

        } catch (InvalidAircraftFormatException e) {
            System.out.println(e.getMessage());
            return false;

        } catch (InvalidAircraftTypeException e) {
            System.out.println(e.getMessage());
            return false;

        } catch (MissingAircraftException e) {
            System.out.println(e.getMessage());
            return false;

        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
            return false;
        }

        return true;
    }

    private boolean isPositiveLong(String str) throws InvalidSimulationRunsException {
        try {
            if (Long.parseLong(str) > 0)
                return true;
            throw new InvalidSimulationRunsException("Invalid number of rounds. The first line must only contain one positive number.");
        } catch (NumberFormatException e) {
			throw new InvalidSimulationRunsException("Invalid number of rounds. The first line must only contain one positive number.");
        }
    }
}
