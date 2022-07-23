import java.util.ArrayList;
import java.util.List;

public class Player {
	// player's information
	private List<Card> hand = new ArrayList<>();
	private int score;
	private String name;

	// no default constructor, must name the player
	Player(String name) {
		this.name = name;
		this.score = 0;
	}

	// returns int of the player's current score
	public int getScore() {
		return this.score;
	}

	// prints out information of the player to the console
	// hand, name, score
	public void describe() {
		System.out.println("Player: " + this.name);
		System.out.println("Score: " + this.score);
		System.out.println("has hand:");
		System.out.println(hand.toString());
	}

	// takes a card out of the player's hand and returns it. also deletes card from
	// the arraylist
	public Card flip() {
		Card selectedCard = this.hand.get(this.hand.size() - 1);
		this.hand.remove(this.hand.size() - 1);
		return selectedCard;
	}

	// takes a card from a given deck and adds it to the players hand
	public void draw(Deck d) {
		this.hand.add(d.draw());
	}

	// increases player's score by 1
	public void incrementScore() {
		this.score++;
	}

	// returns int for the size of player's hand
	public int handSize() {
		return this.hand.size();
	}

	// returns string of player's name
	public String getName() {
		return this.name;
	}
}
