package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;

public class BlackjackHand extends Hand {

	public void BlackjackHand() {
		// this will be the holder of the user's hand
	}

//	public Card hitMe() {
//		Card b = deckInstance.remove(0); 
//		return b; 
//	}

	@Override
	public int getHandValue() {
		// logic for soft and hard aces
		return super.getHandValue();
	}

	@Override
	public void clearHand() {
		// TODO Auto-generated method stub
		super.clearHand();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
