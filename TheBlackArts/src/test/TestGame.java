package test;

import java.util.ArrayList;

import core.Game;
import core.Card;
import core.Deck;
import core.Player;


public class TestGame {
    public static void main(String[] args) {
        // Make a game object
    	Game game = new Game(1);
    	
    	// Announce the game :)
    	game.announceGame();
    	
    	// Make a deck object
    	Deck deck = new Deck();
    	
        // A game has two players
    	Player playerOne = game.getPlayerOne();
    	Player playerTwo = game.getPlayerTwo();
    	
    	System.out.println(playerOne);
    	System.out.println(playerTwo);
    	
    	// Each player has one 52 card deck
    	ArrayList<Card> deckOne = playerOne.getDeck();
    	ArrayList<Card> deckTwo = playerTwo.getDeck();
    	
    	// Print the decks pre shuffle
    	System.out.println("\n***\n");
    	System.out.println(deckOne);
    	System.out.println(deckTwo);
    	
    	// Shuffle each deck
    	deck.shuffleDeck(deckOne);
    	deck.shuffleDeck(deckTwo);
    	
    	// Print the decks post shuffle
    	System.out.println("\n***\n");
    	System.out.println(deckOne);
    	System.out.println(deckTwo);
  
    }
}