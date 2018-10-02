package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Rank;

public class Player extends Hand {
	private int total;
	private int amountBet;

	public void BlackjackHand() {
		
	}

	public int getAmountBet() {
		return amountBet;
	}

	public void setAmountBet(int amountBet) {
		this.amountBet = amountBet;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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
	
	public void calculateAmount(int amountWon, int amountBet) {
		this.total = this.total - amountWon - amountBet; 
	}

}
