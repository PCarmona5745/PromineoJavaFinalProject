import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Card {
	private static StringBuilder builder = new StringBuilder(); // string builder shared amongst all card objects
	private int value; // 2-14
	private int name; // 0-3

	// this map maps an integer to 1 out of 4 shapes and is constant (final)
	// and is shared between all card objects
	private static final Map<Integer, String> possibleShapes = new HashMap<>() {
		/**
		* 
		*/
		private static final long serialVersionUID = 1L; // eclipse suggested adding this but i didn't understand it

		{
			put((Integer) 0, "Diamond");
			put((Integer) 1, "Heart");
			put((Integer) 2, "Spade");
			put((Integer) 3, "Club");
		}
	};

	// this map maps an integer to the 13 values a card could have
	// does not change (final) and is shared between all card objects
	private static final Map<Integer, String> possibleValues = new HashMap<>() {

		/**
			 * 
			 */
		private static final long serialVersionUID = 2393305926036422177L; // eclipse suggested adding this but don't
																			// know its function

		{
			put((Integer) 2, "Two");
			put((Integer) 3, "Three");
			put((Integer) 4, "Four");
			put((Integer) 5, "Five");
			put((Integer) 6, "Six");
			put((Integer) 7, "Seven");
			put((Integer) 8, "Eight");
			put((Integer) 9, "Nine");
			put((Integer) 10, "Ten");
			put((Integer) 11, "Jack");
			put((Integer) 12, "Queen");
			put((Integer) 13, "King");
			put((Integer) 14, "Ace");
		}
	};

	// Default constructor with random values for name and value
	Card() {
		Random rand = new Random();
		this.value = rand.nextInt(13) + 2;
		this.name = rand.nextInt(4);
	}

	// Overloaded constructor with explicitly declared values for name and value
	Card(int value, int name) {
		this.value = value;
		this.name = name;
	}

	// getters and setters
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	// size of the names map
	public static int possibleNamesSize() {
		return possibleShapes.size();
	}

	// size of the values map
	public static int possibleValuesSize() {
		return possibleValues.size();
	}

	// Describe returns a string of the verbally spoken full name of 1/52 cards
	// uses the string builder to build the string and then clears it before
	// returning it
	public String describe() {
		builder.append(possibleValues.get((Integer) value));
		builder.append(" of ");
		builder.append(possibleShapes.get((Integer) name));
		builder.append("s");
		String result = builder.toString();
		builder.setLength(0);
		return result;
	}

	// Same as describe. Used to automatically print out the
	// spoken value of a card whenever this object needs to be converted to a string
	public String toString() {
		builder.append(possibleValues.get((Integer) value));
		builder.append(" of ");
		builder.append(possibleShapes.get((Integer) name));
		builder.append("s");
		String result = builder.toString();
		builder.setLength(0);
		return result;
	}
}
