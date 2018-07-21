package com.skilldistillery.cards.common;

public class Card {

	// suit and rank, set below in constructor 
	private Suit suit;
	private Rank rank;

	// constructor 
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	// hashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	// toString which says rank + " of " + suit.
	@Override
	public String toString() {
		return "Card [suit=" + suit + " of " + ", rank=" + rank + "]";
	}

	// method getValue to return the card's numeric value.
	public int getValue() {
		return rank.getValue();
	}

	// getters for suit and rank 
	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

}
