package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {
	Scanner sc = new Scanner(System.in);
	Deck dk = new Deck();

	public static void main(String[] args) throws Exception {
		BlackjackApp a = new BlackjackApp();
		a.run();
	}

	public void run() {
		// intro to game 
		System.out.println("Welcome to Blackjack!");
		System.out.println("The game is about to start\n");

		dk.shuffle();
		dk.returnCards();
		dealing();

	}

	public void dealing() {
		// instantiate hands 
		BlackjackHandDealer bjhd = new BlackjackHandDealer();
		BlackjackHandPlayer bjhp = new BlackjackHandPlayer();
		
		// clear hands before new game 
		bjhp.clearHand();
		bjhd.clearHand();
		
		// check to make sure there are enough cards 
		int deckSize = dk.checkDeckSize(); 
		
		if (deckSize < 15) {
			run(); 
		}

		// loop for dealing 
		do {
			Card cd1 = dk.dealCard();
			Card cd2 = dk.dealCard();
			bjhd.addCard(cd1);
			bjhp.addCard(cd2);

		} while (bjhd.getCardValue().size() < 2 && bjhp.getCardValue().size() < 2);
		System.out.println(bjhp + "\n");
		System.out.println(bjhd.showDealerFirstCard() + ", xxxxx of XXXXX");

		// if anyone gets blackjack upon dealing 
		if (bjhd.getHandValue() == 21) {
			System.out.println("BLACKJACK!");
			System.out.println("The dealer wins");
			playAgain();
		}
		if (bjhp.getHandValue() == 21) {
			System.out.println("BLACKJACK!");
			System.out.println("You win");
			playAgain();
		} else {
			hitMe(bjhp, bjhd);
		}

	}

	public void hitMe(BlackjackHandPlayer bjhp, BlackjackHandDealer bjhd) {
		// taking cards 
		boolean anotherCard = false;

		System.out.print("\nDo you want another card? Y/N ");
		String newCard = sc.next();
		if (newCard.equalsIgnoreCase("y") || newCard.equalsIgnoreCase("yes")) {
			anotherCard = true;
		} 
		if (newCard.equalsIgnoreCase("n") || newCard.equalsIgnoreCase("no")) {
			anotherCard = false;
		}
		else {
			System.out.println("What'd you say? That's a suspicious response to the dealer. You "
				+ "have been suspected of counting cards and have been removed from this game.");
			System.exit(0);
		}

		// loop for player taking cards 
		while (anotherCard == true) {
			Card cd1 = dk.dealCard();
			bjhp.addCard(cd1);
			System.out.println(bjhp + "\n");
				// if player busts
				if (bjhp.getHandValue() > 21) {
					System.out.println("You busted, the dealer wins");
					playAgain();
				}
				// if player gets blackjack
				if (bjhp.getHandValue() == 21) {
					System.out.println("BLACKJACK!");
					System.out.println("You win");
					playAgain();
				}
			System.out.print("\nDo you want another card? Y/N ");
			String newCard1 = sc.next();
			if (newCard1.equalsIgnoreCase("n") || newCard1.equalsIgnoreCase("no")) {
				anotherCard = false; 
				break; 
			}
		}
		
		// dealer's hand 
		boolean dealerTakeCard = false; 
		
		// should the dealer take cards? 
		if (bjhd.getHandValue() < 17) {
			dealerTakeCard = true; 
		}
		else {
			dealerTakeCard = false; 
		}
		
		// loop for the dealer taking cards 
		while (dealerTakeCard = true) {
			// if the dealer's hand is less that 17, hit
			if (bjhd.getHandValue() < 17) {
				System.out.println("\nThe dealer is taking another card...");
				Card cd1 = dk.dealCard();
				bjhd.addCard(cd1);
				System.out.println(bjhd + "\n");
			}
				// if the dealer busts
				if (bjhd.getHandValue() > 21) {
					System.out.println("The dealer busts, YOU WIN!");
					playAgain();
				}
				// if the dealer gets blackjack
				if (bjhd.getHandValue() == 21) {
					System.out.println("BLACKJACK!");
					System.out.println("The dealer wins.");
					playAgain();
				}
			if (bjhd.getHandValue() == 17 || bjhd.getHandValue() > 17) {
				dealerTakeCard = false; 
				break; 
			}
		}
		
		// if no one busts or gets blackjack 
		int dealerValue = bjhd.getHandValue(); 
		int playerValue = bjhp.getHandValue(); 
		
		if (playerValue < 21 && playerValue > dealerValue) {
			System.out.println("You had " + playerValue + " and the dealer had " + dealerValue);
			System.out.println("YOU WIN!");
			playAgain();
		}
		if (playerValue < 21 && playerValue < dealerValue) {
			System.out.println("You had " + playerValue + " and the dealer had " + dealerValue);
			System.out.println("The dealer wins.");
			System.out.println("I'm not taking you to Vegas with me anytime soon.");
			playAgain(); 
		}
		if (playerValue == dealerValue) {
			System.out.println("You had " + playerValue + " and the dealer had " + dealerValue);
			System.out.println("It's a push!");
			playAgain();
		}
		
	}

	public void playAgain() {
		String playAgain = "";

		System.out.print("Would you like to play again? Y/N ");
		playAgain = sc.next();
		if (playAgain.equalsIgnoreCase("y") || playAgain.equalsIgnoreCase("yes")) {
			dealing(); 
		}
		if (playAgain.equalsIgnoreCase("n") || playAgain.equalsIgnoreCase("no")) {
			System.out.println("Thanks for playing.");
			System.exit(0);
		}
	}

}
