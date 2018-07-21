package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skilldistillery.cards.blackjack.Hand;

public class Deck {

	// Create a class Deck. It will hold a List of Cards.
	private ArrayList<Card> deck = new ArrayList<>();

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public Deck() {
		Suit[] s = Suit.values();
		Rank[] r = Rank.values();

		// initializes the List with all 52 cards in the constructor
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
			System.out.println(deck);
			return deck;
		}

		// removes a Card from the deck
		public Card dealCard() {
			Card c = deck.remove(0);
			System.out.println("\n" + c);
			return c; 
			// this is returning a card off the top of the deck
			// now to add it to a hand 
		}

}
