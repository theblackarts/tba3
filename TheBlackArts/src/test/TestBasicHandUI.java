package test;

import java.util.ArrayList;
import java.util.Scanner;

import core.Game;
import core.Deck;
import core.Player;
import core.Card;

public class TestBasicHandUI {

	public static void main(String[] args) {
		// Make a new game
		Game game = new Game(1);
		
		// Build a deck for Player One
		
		
		// Get Player One's Hand
		
		
		// Make a "Deck Manager"

		
		// Shuffle the deck

	    
		// Deal Player One's starting hand
		
		// Display each card on it's own line
		for (int i = 0, n = playerOneHand.size(); i < n; i++) {
			System.out.println("Card " + (i + 1) + ": " + playerOneHand.get(i));
		}
		
		// Prompt user to enter which card he or she would like to select
		System.out.println("Pick a card, any card: ");
		
		
		// Scan an integer
	    Scanner scanner = new Scanner(System.in);
	    int playerOneHandSelection = scanner.nextInt();
	    
	    // Output which card the player selected
	    System.out.println("You selected card " + playerOneHandSelection);
	    
	    // Now actually return the card that the player selected
	    System.out.println("The card is: " + playerOneHand.get(playerOneHandSelection - 1));
		
		
	}

}
