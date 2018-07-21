package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public abstract class Hand {

	private List<Card> holdsCards = new ArrayList<Card>();

	// getters for both lists
	public List<Card> getHoldsCards() {
		return holdsCards;
	}

	public int getHandValue() {
		// this will return the sum of the value of the hand
		int sum = 0; 
		for (int i = 0; i < holdsCards.size(); i++) {
			Card c = holdsCards.get(i); 
			int value = c.getValue(); 
			sum += value; 
		}
		return sum;
	}

	// add cards to both hands
	public void addCard(Card c) {
		holdsCards.add(c);
	}

	// clear both hands
	public void clearHand() {
		holdsCards.clear();
	}

	// returns the list of cards, not their value for both hands
	public List<Card> getCardValue() {
		return holdsCards;
	}
	
	public String showDealerFirstCard() {
		Card c = holdsCards.get(0); 
		return c.toString();
	}

	@Override
	public String toString() {
//		return "" + getCardValue() + getHandValue(); 
	StringBuilder cardBuilder = new StringBuilder();
	for (int i = 0; i < holdsCards.size(); i++) {
		cardBuilder.append(holdsCards.get(i)); 
		cardBuilder.append(" "); 
	}
	cardBuilder.append("\t"); 
	cardBuilder.append("Total value of hand: "); 
	cardBuilder.append(getHandValue());
	
	
	
	return cardBuilder.toString(); 
	}
	
	

}
