package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.BettingSystem;
import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Rank;

public class BlackjackApp {
	Scanner sc = new Scanner(System.in);
	Deck dk = new Deck();
	BettingSystem bet = new BettingSystem();
	Dealer dealer = new Dealer();
	Player player = new Player();

	public static void main(String[] args) throws Exception {
		BlackjackApp a = new BlackjackApp();
		a.run();
	}

	public void run() {
		// intro to game 
		System.out.println("Welcome to Blackjack!");
		System.out.println("The game is about to start\n");
		System.out.print("How much money are you starting with? ");
		int start = sc.nextInt();
		player.setTotal(start);
		dk.shuffle();
		dk.returnCards();
		dealing();
	}
	
	public void dealing() {
		// check to make sure there are enough cards in the deck
		int deckSize = dk.checkDeckSize(); 
		if (deckSize < 15) {
			dk = new Deck(); 
		}
		
		// clear hands before new game 
		player.clearHand();
		dealer.clearHand();
		
		// place bet 
		if (player.getTotal() <= 0) {
			System.out.println("You have no money to bet with. Please comeback with some money.");
			System.exit(0);
		} 
		else {
			player.setAmountBet(bet.placeBet());
		}
		
		
		// loop for dealing 
		do {
			Card cd1 = dk.dealCard();
			Card cd2 = dk.dealCard();
			dealer.addCard(cd1);
			player.addCard(cd2);

		} while (dealer.getCardValue().size() < 2 && player.getCardValue().size() < 2);
		System.out.println("Your hand:\t" + player + "\n");
		System.out.println("Dealer's hand:\t" + dealer.showDealerFirstCard() + ", xx of XX");

		// if anyone gets blackjack upon dealing 
		if (dealer.getHandValue() == 21) {
			System.out.println("BLACKJACK!");
			System.out.println("The dealer wins");
			bet.setUserWins(false);
			player.setTotal(player.getTotal() - player.getAmountBet());
			System.out.println("You lost $" + player.getAmountBet());
			System.out.println("Your total is $" + player.getTotal());
			playAgain();
		}
		if (player.getHandValue() == 21) {
			System.out.println("BLACKJACK!");
			System.out.println("You win");
			bet.setUserWins(true);
			player.setTotal(player.getTotal() + player.getAmountBet());
			System.out.println("You won $" + (player.getAmountBet() * 2));
			System.out.println("Your total is $" + player.getTotal());
			playAgain();
		} 
		if (dealer.getHoldsCards().contains(Rank.ACE)) {
			for (Card c : dealer.getHoldsCards()) {
				dealer.softAce(c); 
			}
		}
		if (player.getHoldsCards().contains(Rank.ACE)) {
			for (Card c : player.getHoldsCards()) {
				player.softAce(c); 
			}
		}
		else {
			hitMe(player, dealer);
		}

	}

	// taking cards 
	public void hitMe(Player player, Dealer dealer) {
		boolean anotherCard = false;

		System.out.print("\nDo you want another card? Y/N ");
		String newCard = sc.next();
		if (newCard.equalsIgnoreCase("y") || newCard.equalsIgnoreCase("yes")) {
			anotherCard = true;
		} 
		if (newCard.equalsIgnoreCase("n") || newCard.equalsIgnoreCase("no")) {
			anotherCard = false;
		}

		// loop for player taking cards 
		while (anotherCard == true) {
			Card cd1 = dk.dealCard();
			if (cd1.getRank() == Rank.ACE) {
				player.softAce(cd1); 
			}
			player.addCard(cd1);
			System.out.println("Your hand:\t" + player + "\n");
				// if player busts
				if (player.getHandValue() > 21) {
					System.out.println("You busted, the dealer wins");
					bet.setUserWins(false);
					player.setTotal(player.getTotal() - player.getAmountBet());
					System.out.println("You lost $" + player.getAmountBet());
					System.out.println("Your total is $" + player.getTotal());
					playAgain();
				}
				// if player gets blackjack
				if (player.getHandValue() == 21) {
					System.out.println("BLACKJACK!");
					bet.setUserWins(true);
					System.out.println("You win");
					player.setTotal(player.getTotal() + player.getAmountBet());
					System.out.println("You won $" + (player.getAmountBet() * 2));
					System.out.println("Your total is $" + player.getTotal());
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
		if (dealer.getHandValue() < 17) {
			dealerTakeCard = true; 
		}
		else {
			dealerTakeCard = false; 
		}
		
		// loop for the dealer taking cards 
		while (dealerTakeCard = true) {
			// if the dealer's hand is less that 17, hit
			if (dealer.getHandValue() < 17) {
				System.out.println("\nThe dealer is taking another card...");
				Card cd1 = dk.dealCard();
				if (cd1.getRank() == Rank.ACE) {
					dealer.softAce(cd1); 
				}
				dealer.addCard(cd1);
				System.out.println("Dealer's hand:\t" + dealer + "\n");
			}
				// if the dealer busts
				if (dealer.getHandValue() > 21) {
					System.out.println("The dealer busts, YOU WIN!");
					bet.setUserWins(true);
					player.setTotal(player.getTotal() + player.getAmountBet());
					System.out.println("You won $" + (player.getAmountBet() * 2));
					System.out.println("Your total is $" + player.getTotal());
					playAgain();
				}
				// if the dealer gets blackjack
				if (dealer.getHandValue() == 21) {
					System.out.println("BLACKJACK!");
					System.out.println("The dealer wins.");
					bet.setUserWins(false);
					player.setTotal(player.getTotal() - player.getAmountBet());
					System.out.println("You lost $" + player.getAmountBet());
					System.out.println("Your total is $" + player.getTotal());
					playAgain();
				}
			if (dealer.getHandValue() == 17 || dealer.getHandValue() > 17) {
				dealerTakeCard = false; 
				break; 
			}
		}
		
		// if no one busts or gets blackjack 
		int dealerValue = dealer.getHandValue(); 
		int playerValue = player.getHandValue(); 
		
		if (playerValue < 21 && playerValue > dealerValue) {
			System.out.println("You had " + playerValue + " and the dealer had " + dealerValue);
			System.out.println("YOU WIN!");
			bet.setUserWins(true);
			player.setTotal(player.getTotal() + player.getAmountBet());
			System.out.println("You won $" + (player.getAmountBet() * 2));
			System.out.println("Your total is $" + player.getTotal());
			playAgain();
		}
		if (playerValue < 21 && playerValue < dealerValue) {
			System.out.println("You had " + playerValue + " and the dealer had " + dealerValue);
			System.out.println("The dealer wins.");
			bet.setUserWins(false);
			player.setTotal(player.getTotal() - player.getAmountBet());
			System.out.println("You lost $" + player.getAmountBet());
			System.out.println("Your total is $" + player.getTotal());
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