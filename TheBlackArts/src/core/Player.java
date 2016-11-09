/*
 *  A player is the primary user of The Black Arts game.
 */

package core;

import java.util.ArrayList;

public class Player {
   
    private String firstName;
    private String lastName;
    private int hitPoints = 100;
    public static final int OPENINGHANDSIZE = 7;
    
    // Each player has one deck
    Deck deckManager = new Deck();
    private ArrayList<Card> deck =
    		deckManager.buildTestDeck();
    
    // Each player has one hand
    private ArrayList<Card> hand = new ArrayList<Card>(OPENINGHANDSIZE);

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public Deck getDeckManager() {
		return deckManager;
	}

	public void setDeckManager(Deck deckManager) {
		this.deckManager = deckManager;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	// Constructors
    public Player(){
    
    }
    
    public Player(String firstName) {
        this.firstName = firstName;
    }
    
    
    // print the human readable form of the hand
    public void getHumanReadableHand(ArrayList<Card> hand) {
    	for (int i = 0, n = hand.size(); i < n; i++) {
    		System.out.println(hand.get(i).getCardName());
    	}
    }
}