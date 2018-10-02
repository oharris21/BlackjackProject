package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Rank;

public abstract class Hand {
	private List<Card> holdsCards = new ArrayList<Card>();
	
	public Hand() {
		
	}
	
	// add cards to both hands
	public void addCard(Card c) {
		holdsCards.add(c);
	}
	
	// clear both hands
	public void clearHand() {
		holdsCards.clear();
	}
	
	// returns the list of cards, not their value, for both hands
	public List<Card> getCardValue() {
		return holdsCards;
	}
	
	public String showDealerFirstCard() {
		Card c = holdsCards.get(0);
		return c.toString();
	}
	
	public Card softAce(Card c) {
		if (c.getRank() == Rank.ACE && getHandValue() < 11) {
			c.setValue(11);
		}
		else {
			c.setValue(1);
		}
		return c; 
	}

	public List<Card> getHoldsCards() {
		return holdsCards;
	}

	// returns the sum of the value of the hand
	public int getHandValue() {
		int sum = 0;
		for (int i = 0; i < holdsCards.size(); i++) {
			Card c = holdsCards.get(i);
			int value = c.getValue();
			sum += value;
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder cardBuilder = new StringBuilder();
		for (int i = 0; i < holdsCards.size(); i++) {
			cardBuilder.append(holdsCards.get(i));
			cardBuilder.append(", ");
		}
		cardBuilder.append("\t");
		cardBuilder.append("Total value of hand: ");
		cardBuilder.append(getHandValue());
		return cardBuilder.toString();
	}
}
