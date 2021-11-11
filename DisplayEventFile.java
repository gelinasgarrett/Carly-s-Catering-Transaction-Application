
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * DisplayEventFile establishes the absolute path to the file used 'EventData.txt' and prints out the
 * information in the file by separating it based on commas and printing the lines
 */
public class DisplayEventFile {

	public static void main(String[] args) {

		// Finds the relative path and converts it to an absolute path
		String fileName = "EventData.txt";
		Path inputPath = Paths.get(fileName);
		Path fullPath = inputPath.toAbsolutePath();
		System.out.println("Checking for file at " + fullPath);

		// If the file exists this segment will proceed to read the file
		if (Files.exists(fullPath)) {
			System.out.println("The file was found, reading information from file...");
			InputStream input = null;
			try {
				//Once the file is found, a Bufferedreader is created
				input = Files.newInputStream(fullPath);
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				String temp;

				// The while loop checks to make sure there is a line to read that is not empty
				while ((temp = reader.readLine()) != null) {
					String[] arrSplit = temp.split(",");
					System.out.println("\nEvent Information...");
					//The segments are printed in order by a label based on the location in the line
					System.out.println("Event ID: " + arrSplit[0]);
					System.out.println("Number of guests: " + arrSplit[1]);
					System.out.println("Event type: " + arrSplit[2]);
					System.out.println("Price: $" + arrSplit[3] + "\n");

				}
				// Closes the buffered reader
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		//If the file is not found, the message will be thrown
		} else {
			System.out.println("No EventData saved yet");
		}

	}
}