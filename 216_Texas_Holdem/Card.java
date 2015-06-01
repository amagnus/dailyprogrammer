package texasholdem8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Card {

	enum Kind {
		CLUBS, HEARTS, SPADES, DIAMONDS;

		private final static List<Kind> VALUES = Arrays.asList(values());
		private final static int SIZE = VALUES.size();

		public static Kind getRandomValue() {
			return VALUES.get(RANDOM.nextInt(SIZE));
		}
	}

	enum Num {
		AS, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO;

		private final static List<Num> VALUES = Arrays.asList(values());
		private final static int SIZE = VALUES.size();

		public static Num getRandomValue() {
			return VALUES.get(RANDOM.nextInt(SIZE));
		}
	}

	final private Kind KIND;
	final private Num NUMBER;
	private static final Random RANDOM = new Random();

	Card(Num number, Kind kind) {
		this.KIND = kind;
		this.NUMBER = number;
	}

	public static Card getCard() {
		return new Card(Num.getRandomValue(), Kind.getRandomValue());
	}

	@Override
	public String toString() {
		return NUMBER + " of " + KIND;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((KIND == null) ? 0 : KIND.hashCode());
		result = prime * result + ((NUMBER == null) ? 0 : NUMBER.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Card) {
			Card foo = (Card) obj;
			if (KIND.equals(foo.KIND) && NUMBER.equals(foo.NUMBER)) {
				return true;
			}
		}
		return false;
	}

}
