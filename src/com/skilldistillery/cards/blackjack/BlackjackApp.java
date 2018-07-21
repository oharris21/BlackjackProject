package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {
		Deck dk = new Deck(); 
	
	public static void main(String[] args) throws Exception {
		BlackjackApp a = new BlackjackApp(); 
		a.run(); 
	}
	
	public void run() {
		System.out.println("Welcome to Blackjack!");
		System.out.println("The game is about to start");
		System.out.println();
		dk.shuffle();
		dk.returnCards(); 
		dk.dealCard();
		// call dealer to deal two cards each
	}

	public void dealing() throws Exception {
		Scanner sc = new Scanner(System.in);
		BlackjackApp a = new BlackjackApp(); 
		Deck d = new Deck();
		int howMany = 0; 

		//Write a program to ask a user how many cards they want.
		try {
			System.out.print("How many cards do you want? ");
			howMany = sc.nextInt();

			//Handle the case where users enter a non-integer or a number greater than 52: print an error message.
			if (howMany > 52) {
				throw new IllegalArgumentException("Amount of cards cannot be less than 52.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Please enter a whole number");
		}
		// call deck method 
		d.dealCard(); 
	}
	
}
