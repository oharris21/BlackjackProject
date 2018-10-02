package com.skilldistillery.cards.common;

import java.util.Scanner;

public class BettingSystem {
	private boolean userWins;
	
	Scanner sc = new Scanner(System.in); 
	
	public int placeBet() {
		int amount = 0; 
		System.out.println("Would you like to place a bet on this hand?");
		String response = sc.next(); 
		if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
			System.out.println("How much would you like to bet?");
			amount = sc.nextInt();
		}
		return amount;
	}
	
	public boolean isUserWins() {
		return userWins;
	}

	public void setUserWins(boolean userWins) {
		this.userWins = userWins;
	}

}
