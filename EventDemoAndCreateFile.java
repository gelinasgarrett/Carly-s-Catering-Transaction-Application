
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *  EventDemoAndCreateFile essentially combines the old EventDemo program with the functionality
 *  of writing the information created in the Event objects and writing it to a file.
 *  Once finished writing, it will call the DisplayEventFile class to handle the printing of the information
 */
public class EventDemoAndCreateFile {
	public static void main(String[] args) {

		// Variables used within the main method
		int guests;
		int typeOfEvent;
		String eventNum;

		// Array event with the size of 3 to hold 3 Event objects
		Event[] event = new Event[3];

		// For loop the size of the event array which creates object and stores
		// information about each Event object
		for (int i = 0; i < event.length; i++) {
			event[i] = new Event();

			// Accesses different methods within EventDemo to retrieve user input
			eventNum = askUserForEventNumber();
			guests = askUserForGuests();
			typeOfEvent = askUserForEventType();

			// Sets the user input retrieved to the respective Event Objects
			event[i].setEventNumber(eventNum);
			event[i].setGuests(guests);
			event[i].setEvent(typeOfEvent);
			event[i].setPrice();
		}
		// Calls two events to write the information to a text file and print it out to
		// the console
		writeDataToFile(event);
		DisplayEventFile.main(args);
	}

	/*
	 * Pass the event object array to be written into a text file
	 */
	public static void writeDataToFile(Event[] event) {

		/*
		 * Try/catch block to handle the exceptions of writing to file
		 */
		try {
			/*
			 * Creates the EventData file and creates the necessary built-in Java objects to
			 * write to a file and append to the existing information if the file exists
			 */
			File eventDataFile = new File("EventData.txt");
			FileWriter fileWriter = new FileWriter(eventDataFile, true);
			BufferedWriter buffer = new BufferedWriter(fileWriter);
			PrintWriter writer = new PrintWriter(buffer);

			// While loops and variables that write to the PrintWriter object, saving the
			// information to the txt file
			int index = 0;
			String delimeter = ",";
			while (index < event.length) {
				if (event[index] != null) {
					writer.println(event[index].getEventNumber() + delimeter + event[index].getGuests() + delimeter
							+ event[index].getEventType() + delimeter + event[index].getPrice() + delimeter);
				}
				index = (index + 1);
			}
			System.out.println("The information was written to the file. Closing writer...");
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Prompts the user with the types of events available and asks the user to
	 * input a number relating to their type
	 */
	@SuppressWarnings("resource")
	public static int askUserForEventType() {

		int temp = -1;
		while (temp < 1 || temp > 5) {
			int eventType;
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter a number corresponding to your event type (Ex: enter 1 for Wedding)\n");
				for (int i = 0; i < Event.EVENT_TYPES.length; i++) {
					System.out.println(Event.EVENT_TYPES[i]);
				}
				eventType = (input.nextInt() - 1);
				temp = eventType;
			} catch (InputMismatchException e) {
				System.out.println("\nWrong input type. Must be a whole number...");
			}
		}
		return temp;

	}

	/*
	 * Prompts the user with their choice of event number stored in a String. Must
	 * be one letter followed by three numbers
	 */
	@SuppressWarnings("resource")
	public static String askUserForEventNumber() {

		String num;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter event number. It must be one letter followed by three numbers (Ex. F555): ");
		num = input.nextLine();
		return num;

	}

	/*
	 * Prompts the user to input an integer for how many guests are attending the
	 * event
	 */
	@SuppressWarnings("resource")
	public static int askUserForGuests() {

		int temp = -1;
		while (temp < 5 || temp > 200) {
			int entree1;
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter an integer between 5 and 200 for your guest amount: ");
				entree1 = input.nextInt();
				temp = entree1;
			} catch (InputMismatchException e) {
				System.out.println("\nWrong input type. Must be a whole number...");
			}
		}
		return temp;

	}

	/*
	 * Prints the details of each Event object after the data collection is complete
	 */
	public static void displayDetails(Event event) {

		System.out.println("\nEvent #" + event.getEventNumber());
		System.out.println("The event will have " + event.getGuests() + " guests!");
		System.out.println("The event is behind held for a(n) " + event.getEventType() + " event");

	}
}