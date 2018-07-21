package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public abstract class Hand {
	Deck dk = new Deck(); 
	private List<Card> holdsCards = new ArrayList<Card>(); 
	holdsCards.add(); 
	// trying to add card returned from deck to hand 


	public int getHandValue() {
		// this will return the sum of the value of the hand
		int a = 0;
		return a;
	}

	public void addCard(Card c) {
		c = dk.dealCard(); 
		holdsCards.add(c); 
		System.out.println(c);
	}

	public void clearHand() {
		holdsCards.clear();
	}

	public List<Card> getCards() {
		// returns the list of cards, not their value
		return holdsCards;
	}

	@Override
	public String toString() {
		return "Hand [getHandValue()=" + getHandValue() + ", getCards()=" + getCards() + "]";
	}

}
