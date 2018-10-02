package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	// List of Cards
	private ArrayList<Card> deck = new ArrayList<>();

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public Deck() {
		Suit[] s = Suit.values();
		Rank[] r = Rank.values();

		// initializes the deck with all 52 cards
		for (int i = 0; i < s.length; i++) {
			Suit s1 = s[i];
			for (int j = 0; j < r.length; j++) {
				Rank r1 = r[j];
				Card c = new Card(s1, r1);
				deck.add(c);
				// deck now has 52 cards in it
			}
		}
	}
	
	// returns the number of cards still in the deck
		public int checkDeckSize() {
			int numberOfCards = deck.size();
			return numberOfCards;
		}

		// shuffles the deck.
		public void shuffle() {
			System.out.println("sound of cards shuffling......\n");
			Collections.shuffle(deck);
			// deck is now shuffled
		}

		public List<Card> returnCards() {
			return deck;
		}

		// removes a Card from the top of the deck
		public Card dealCard() {
			Card c = deck.remove(0);
			return c; 
		}
}
