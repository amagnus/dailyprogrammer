package texasholdem8;

public class Hand {

	final Card CARD1;
	final Card CARD2;

	Hand(Card card1, Card card2) {
		this.CARD1 = card1;
		this.CARD2 = card2;
	}

	@Override
	public String toString() {
		return CARD1 + ", " + CARD2;
	}

}
