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
    	
    	System.out.println("This match is between " + playerOne.getFirstName() + " and " + playerTwo.getFirstName()
    		+ ".");
    	System.out.println("Good luck & have fun!");
    	System.out.println();
    	
    	// Each player has one 52 card deck
    	ArrayList<Card> deckOne = playerOne.getDeck();
    	ArrayList<Card> deckTwo = playerTwo.getDeck();
    	
    	// Shuffle each deck
    	deck.shuffleDeck(deckOne);
    	deck.shuffleDeck(deckTwo);
    	
    	System.out.println("The decks have been shuffled.");
    	
    	System.out.println(playerOne.getFirstName() +
    		" will play first."); // TODO: A way to randomly select first player
    	
    	game.nextTurn(); // turn "0" to turn 1
    	System.out.println("\n:: Turn " + game.getTotalTurns() + "::\n");
    	    	
    	// Deal an opening hand of 7 cards to Alice
    	playerOne.setHand(deck.dealSevenCards(deckOne));
    	ArrayList<Card> handOne = playerOne.getHand();    	
    	
    	// Ask Alice to pick a card
    	game.selectOneHandCard(handOne);
    }
}