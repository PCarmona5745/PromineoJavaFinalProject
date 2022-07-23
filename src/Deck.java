import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	// not static, every deck is unique
	private List<Card> cards = new ArrayList<>();

	// constructor adds all possible cards in the deck
	// designed for expansion of the type and value of the cards
	// but may break due to the way 'value' works for a standard deck
	Deck() {
		for (int i = 0; i < Card.possibleNamesSize(); i++) {
			for (int j = 0; j < Card.possibleValuesSize(); j++) {
				// uses card's overloaded constructor
				cards.add(new Card(j + 2, i));
			}
		}
	}

	// reorganizes the order of the cards in the deck
	public void shuffle() {
		// part of the standard Collections methods
		Collections.shuffle(this.cards);
	}

	// pulls out the very last card in the list and returns it
	public Card draw() {
		Card selectedCard = this.cards.get(cards.size() - 1);
		this.cards.remove(this.cards.size() - 1);
		return selectedCard;
	}

	// calls toString method for a list (used the toString method in the Card object
	public String toString() {
		return this.cards.toString();
	}

	// returns an int for the current size of the deck
	public int size() {
		return this.cards.size();
	}
}
