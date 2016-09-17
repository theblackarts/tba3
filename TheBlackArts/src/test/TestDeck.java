package test;

import java.util.ArrayList;

import core.Deck;
import core.Card;

public class TestDeck {
	public static void main(String[] args) {
		Deck deckManager = new Deck();
		
		ArrayList<Card> testDeckHand;
		
		Card oneCardFromTestDeck;
		
		// A "blank" deck of 52 elements (an ArrayList of size 52)
		ArrayList<Card> testDeck = deckManager.getBlankDeck();
		
		// Assign Cards to the "blank" deck
		deckManager.buildGenericDeck(testDeck);
		
		// Print out the cards
		System.out.println(testDeck);
		
		// Can we shuffle?
		deckManager.shuffleDeck(testDeck);
		
		// Print out the shuffled deck
		System.out.println("\n" + testDeck);
		
		// Can we deal seven cards (in other words an opening hand)?
		testDeckHand = deckManager.dealSevenCards(testDeck);
		
		// Print out the dealt cards
		System.out.println("\n" + testDeckHand);
		
		// Check that the cards have been removed from the deck
		System.out.println("\nThe size of the deck is now " + testDeck.size());
		
		// Can we deal one card?
		oneCardFromTestDeck = deckManager.dealOneCard(testDeck);
		
		// Print out that card
		System.out.println("\n" + oneCardFromTestDeck);
		
		// Make sure the one card that was dealt was removed from the deck
		System.out.println("\n" + testDeck.size());
		
	}
}
