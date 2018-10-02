package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Rank;

public class Dealer extends Hand {
	
	public void BlackjackHand() {
		
	}

	@Override
	public int getHandValue() {
		return super.getHandValue();
	}

	@Override
	public void clearHand() {
		super.clearHand();
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public Card softAce(Card c) {
		if (c.getRank() == Rank.ACE && getHandValue() < 11) {
			c.setValue(11);
		}
		else {
			c.setValue(1);
		}
		return c; 
	}

}
