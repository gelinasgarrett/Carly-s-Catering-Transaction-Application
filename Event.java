
 import java.io.Serializable;

/*
 * Class Event creates an Event objects and fill it with three variables,
 * eventNumber, numOfGuests, and eventType
 */
public class Event implements Serializable {

	// final variables which are intended to be unchanged throughout the entire
	// program
	public final static String EVENT_TYPES[] = { "Wedding", "Baptism", "Birthday", "Corporate", "Other" };
	public static final int LARGE_EVENT_MAX = 50;
	public static final int EVENT_NUM_LENGTH = 4; // The required length of the contract number
	public static double pricePerGuestHigh = 35.00;
	public static double pricePerGuestLow = 32.00;

	// primary variables used to store information about the Object
	private String eventNumber;
	private int numOfGuests;
	private int eventType;
	private double price;

	/*
	 * Default constructor assigning event number, guests and event type
	 */
	public Event() {
		this("A000", 0, 0);

	}

	/*
	 * Creates the event object with set variables input from the user
	 */
	public Event(String num, int guests, int eventType) {

		setEventNumber(num);
		setGuests(guests);
		setEvent(eventType);

	}

	/*
	 * Returns the values of the final array EVENT_TYPES to display to the user in
	 * EventDemo
	 */
	public static String[] getEVENT_TYPES() {
		return EVENT_TYPES;
	}

	/*
	 * Sets the type of event and ensures that it defaults to 'Other' if it is an
	 * invalid input
	 */
	public void setEvent(int selectedEventType) {

		if (selectedEventType > EVENT_TYPES.length | selectedEventType < 0) {
			eventType = EVENT_TYPES.length - 1;
		} else {
			eventType = selectedEventType;
		}

	}

	/*
	 * Returns the integer value of the event type allocated by the user
	 */
	public int getEventTypeInt() {
		return eventType;
	}

	/*
	 * Uses the integer eventType as the position marker in the EVENT_TYPES array
	 * and displays that corresponding event
	 */
	public String getEventType() {
		return EVENT_TYPES[eventType];
	}

	/*
	 * Sets the eventNumber variable. This is the identifier of each party/event,
	 * not the eventType variable
	 */
	public void setEventNumber(String num) {
		if (num.length() != EVENT_NUM_LENGTH || !Character.isLetter(num.charAt(0)) || !Character.isDigit(num.charAt(1))
				|| !Character.isDigit(num.charAt(2)) || !Character.isDigit(num.charAt(3))) {
			this.eventNumber = "A000";
		} else {
			this.eventNumber = num.toUpperCase();
		}
	}

	/*
	 * Returns the EventNumber in string format. Such as "H023"
	 */
	public String getEventNumber() {
		return eventNumber;
	}

	/*
	 * Sets the number of guests by the input of the user for a particular object
	 */
	public void setGuests(int gsts) {
		numOfGuests = gsts;
	}

	/*
	 * Returns the amount of guests attending an event, as set by the user for the
	 * current object
	 */
	public int getGuests() {
		return numOfGuests;
	}

	/*
	 * Decides if the event is large or not and returns a boolean value
	 */
	public boolean isLargeEvent() {
		if (numOfGuests >= LARGE_EVENT_MAX) {
			return true;
		} else {
			return false;
		}
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice() {
		if(isLargeEvent() == true) {
			this.price = getGuests() * pricePerGuestHigh;
		} else {
			this.price = getGuests() * pricePerGuestLow;
		}
	}

	@Override
	public String toString() {
		return "Event [eventNumber=" + eventNumber + ", numOfGuests=" + numOfGuests + ", eventType=" + eventType
				+ ", price=" + price + "]";
	}

	
}