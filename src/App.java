
public class App {

	public static void main(String[] args) {

		// creates a new deck
		Deck d = new Deck();
		System.out.println("Deck created of size: " + d.size());
		System.out.println(d + "\n");

		// shuffles the order of the deck
		d.shuffle();
		System.out.println("Deck shuffled: ");
		System.out.println(d + "\n");

		// creates 2 players
		Player colby = new Player("Colby");
		Player jack = new Player("Jack");

		// for loop gives every other player a card from the deck
		// while loop might be better but assignment calls for a for loop
		int initialDeckSize = d.size();
		for (int i = 0; i < initialDeckSize; i++) {
			if (i % 2 == 0) {
				colby.draw(d);
			} else {
				jack.draw(d);
			}
		}

		// temporary card value storage
		int p1Val = 0;
		int p2Val = 0;
		int initialHandSize = colby.handSize();

		// test functionality of describe (could put it in the loop for each round
		// but I didn't want to clutter the terminal more than i already have
		colby.describe();
		jack.describe();

		// flips through each player's hand to compare values, adding score to the
		// winning player
		// while loop would still be better here

		for (int i = 0; i < initialHandSize; i++) {

			p1Val = colby.flip().getValue();
			p2Val = jack.flip().getValue();

			if (p1Val == p2Val) {
				// do nothing
				continue;
			} else if (p1Val > p2Val) {
				colby.incrementScore();
			} else if (p2Val > p1Val) {
				jack.incrementScore();
			}
//			System.out.println("\n\n\n");
//			System.out.println("------ Round " + (i+1) + " ---------");
//			colby.describe();
//			jack.describe();

		}

		// using getters
		int finalP1Score = colby.getScore();
		int finalP2Score = jack.getScore();

		System.out.println("\n\n\n");

		// prints out the winner!
		if (finalP1Score == finalP2Score) {
			System.out.println("It's a draw!!");
		} else if (finalP1Score > finalP2Score) {
			System.out.println(colby.getName() + " won!");
		} else if (finalP2Score > finalP1Score) {
			System.out.println(jack.getName() + " won!");
		}

	}

}
