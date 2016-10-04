/*
 *  A player is the primary user of The Black Arts game.
 */

package core;

import java.util.ArrayList;

public class Player {
   
    // Data fields
    private int playerID;
    private String firstName;
    private String lastName;
    private String userName;
    private int hitPoints = 100;
    public static final int OPENINGHANDSIZE = 7;
    
    // Each player has one deck
    // NOTE: This is where the player's deck is being built
    // TODO: Make a setDeck to change out a player's deck
    Deck deckManager = new Deck();
    private ArrayList<Card> deck =
    		deckManager.buildDeckOfHalfGoldAndHalfBears();
    
    // Each player has one hand
    private ArrayList<Card> hand = new ArrayList<Card>(OPENINGHANDSIZE);

    // Each player has a goldPool (are we using this in Game?)
    private int goldPool = 0;

    // Constructors
    public Player(){
    
    }
    
    public Player(String firstName) {
        this.firstName = firstName;
    }
    
    public Player(int id, String fname, String lname, int hp) {
        this.playerID = id;
        this.firstName = fname;
        this.lastName = lname;
        this.hitPoints = hp;
    }
    
    // Setters
    public void setHand(ArrayList<Card> hand) {
    	this.hand = hand;
    }
    
    public void setPlayerID(int id) {
        this.playerID = id;
    }
    
    public void setFirstName(String name) {
        this.firstName = name;
    }
    
    public void setLastName(String name) {
        this.lastName = name;
    }
    
    public void setUserName(String name) {
        this.userName = name;
    }
    
    public void setHitPoints(int hp) {
        this.hitPoints = hp;
    }
    
    public void setGoldPool(int goldPool) {
        this.goldPool = goldPool;
    }
    
    
    // Getters
    public int getPlayerID() {
        return playerID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public int getHitPoints() {
        return hitPoints;
    }
    
    public int getGoldPool() {
        return goldPool;
    }
    
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public ArrayList<Card> getDeck() {
    	return deck;
    }
    
    
    // print the human readable form of the hand
    public void getHumanReadableHand(ArrayList<Card> hand) {
    	for (int i = 0, n = hand.size(); i < n; i++) {
    		System.out.println(hand.get(i).getCardName());
    	}
    }
}