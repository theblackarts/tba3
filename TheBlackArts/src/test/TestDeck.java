package test;

import java.util.ArrayList;

import core.Deck;
import core.Card;

public class TestDeck {
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.buildDeckOfHalfGoldAndHalfBears("Bears and Gold");
		System.out.println(deck.getDeckName() + " is a deck of " + deck.getDeck().size() + " cards.");
		ArrayList<Card> gameDeck = deck.getDeck();
		deck.shuffleDeck(gameDeck);
		for (Card card : gameDeck)
			System.out.println(card.getCardName());
	}
}
