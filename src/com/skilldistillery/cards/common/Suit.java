package com.skilldistillery.cards.common;

public enum Suit {
  HEARTS('\u2764'), SPADES('\u2660'), CLUBS('\u2663'), DIAMONDS('\u2666');
  private char name;
  
  

  Suit(char name) {
    this.name = name;
  }

  @Override
  public String toString() {
	String s = "" + name;
    return s;
  }
  
}