package texasholdem8;

import java.util.Scanner;
import java.util.Set;
import com.google.common.collect.ImmutableSet;

public class Dealer {

	static Set<Card> usedCards = ImmutableSet.of();

	private static Card drawCard() {
		Card card = Card.getCard();
		while (usedCards.contains(card)) {
			card = Card.getCard();
		}
		usedCards = new ImmutableSet.Builder<Card>()
				.addAll(usedCards)
				.add(card)
				.build();
		return card;
	}

	private static Hand distributeHand() {
		return new Hand(drawCard(), drawCard());
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("How many players (2-8) ?");
		int virtualPlayers = Integer.parseInt(scan.nextLine()) -1;
		scan.close();
		System.out.println("");

		System.out.print("Your hand: ");
		System.out.print(distributeHand());
		System.out.println("");

		for (int i=1; i <= virtualPlayers; i++) {
			System.out.print("CPU " + i + " hand: ");
			System.out.print(distributeHand());
			System.out.println("");
		}
		System.out.println("");

		drawCard();
		System.out.print("Flop: ");
		for (int i=1; i < 4; i++) {
			System.out.print(drawCard() + ", ");
		}
		System.out.println("");

		drawCard();
		System.out.print("Turn: ");
		System.out.print(drawCard());
		System.out.println("");

		drawCard();
		System.out.print("River: ");
		System.out.print(drawCard());
	}

}
