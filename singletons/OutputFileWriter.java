package singletons;

import java.io.FileWriter;
import java.io.IOException;

public class OutputFileWriter {
	private static OutputFileWriter instance;

	private OutputFileWriter() {}

	public static OutputFileWriter getInstance() {
		if (instance == null) {
			instance = new OutputFileWriter();
		}
		return instance;
	}

	public void writeOutput(String output) {
		try (FileWriter writer = new FileWriter("simulation.txt", true)) {
			writer.write(output + "\n");
		} catch (IOException e) {
			System.out.println("There was an error while trying to write to 'simulation.txt'.");
		}
	}
}