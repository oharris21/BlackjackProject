package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	//Create a class Deck. It will hold a List of Cards.
	List<Card> deck = new ArrayList<>();

	//In the constructor, initialize the List with all 52 cards.
	public Deck() {
		Suit[] s = Suit.values();
		Rank[] r = Rank.values();

		for (int i = 0; i < s.length; i++) {
			Suit s1 = s[i];
			for (int j = 0; j < r.length; j++) {
				Rank r1 = r[j];
				Card c = new Card(s1, r1);
				deck.add(c);
				
			}
		}
	}

	//Add a method checkDeckSize which returns the number of cards still in the deck.
	public int checkDeckSize() {
		int numberOfCards = deck.size();
		return numberOfCards;
	}

	//Add a method dealCard that removes a Card from the deck.
	public Card dealCard() {
		Card a = deck.remove(0);
		return a; 
	}

	//Add a method shuffle to shuffle the deck.
	public void shuffle() {
		Collections.shuffle(deck);
	}

}
