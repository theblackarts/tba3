package test;

import java.util.ArrayList;

import core.Game;
import core.Card;
import core.Deck;
import core.Player;


public class TestGame {
    public static void main(String[] args) {
        // Make a game object
    	Game game = new Game();
    	
        /*
         *  A game has two players
         *  [validated]
         */
    	Player playerOne = game.getPlayerOne();
    	Player playerTwo = game.getPlayerTwo();
    	
    	System.out.println(playerOne);
    	System.out.println(playerTwo);
    	
    	
    	// Each player has one 52 card deck
    	// Already taken care of by the game object
    	/* 
    	 * This is no longer working because of refactor of
    	 * which class is responsible for building a deck.
    	 * TODO: Fix this.
    	 * ArrayList<Card> gameDeckOne = game.getDeckOne();
    	ArrayList<Card> gameDeckTwo = game.getDeckTwo();
    	
    	
    	System.out.println("PRE Shuffle gameDeckOne");
    	System.out.println(gameDeckOne);
    	
    	// Let's shuffle deckOne
    	game.deckManager.shuffleDeck(gameDeckOne);
    	System.out.println("POST Shuffle gameDeckOne");
    	System.out.println(gameDeckOne);
    	
    	game.deckManager.shuffleDeck(gameDeckTwo);
    	
    	// Each player is dealt a 7 card hand from their deck
        ArrayList<Card> playerOneHand = playerOne.getHand();
        playerOneHand = game.deckManager.dealSevenCards(gameDeckOne);
        // ArrayList<Card> playerTwoHand = playerTwo.getHand();
        // playerTwoHand = game.deckManager.dealSevenCards(gameDeckTwo);
        
        System.out.println("Player One, your hand is: " + playerOneHand);
        //System.out.println("Player Two, your hand is: " + playerTwoHand);
    	
    	// Ensure the cards are being removed from each deck
        System.out.println("Player One, your deck has " + gameDeckOne.size() +
        		" cards left.");
        System.out.println("Player Two, your deck has " + gameDeckTwo.size() +
        		" cards left.");
        
        // Deal one card to the "game"
        System.out.println("Hi, I'm the deck manager, and I just dealt" +
        		" one card from player one's deck," + " " +
        		game.deckManager.dealOneCard(gameDeckOne, 0));
        
        // Validate that the card has been removed from player one's deck
        System.out.println(gameDeckOne.size());
        
        // Deal one card to player one's hand
        playerOneHand.add(game.deckManager.dealOneCard(gameDeckOne, 0));
        
        // Print player one's hand size (it should be 8)
        System.out.println(playerOneHand.size());
        
        // Print player one's deck size, it should be 43
        System.out.println(gameDeckOne.size());
        */
    }

}