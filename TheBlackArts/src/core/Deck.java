package core;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    
    // Data fields
    private int deckID;
    private String deckName;
    private ArrayList<Card> blankDeck = new ArrayList<Card>(DECKSIZE);
    public static final int DECKSIZE = 52; // A deck is made up of 52 cards
    public static final int OPENINGHANDSIZE = 7; // An opening hand is made up of 7 cards

    
    // Constructors
    public Deck() {
        
    }
    
    public Deck(String name) {
    	this.deckName = name;
    }
    
    
    // Setter methods
    public void setDeckID(int id) {
        this.deckID = id;
    }
    
    public void setDeckName(String name) {
        this.deckName = name;
    }
    

    // Getter methods
    public ArrayList<Card> getBlankDeck() {
        return blankDeck;
    }
    
    public String getDeckName() {
    	return deckName;
    }
    
    // Method to populate an array that contains 52 new cards
    public void buildGenericDeck(ArrayList<Card> deck) {
        for (int i = 0, n = DECKSIZE; i < n; i++) {
           deck.add(new Card(i)); 
        }
    }
    
    // Method to build a deck of cards
    // Need a pool of card objects to choose from
    // TODO: Create a pool of cards
    
    /** Create a deck of half gold cards and half bear assets */
    // Make 26 Club Activators and store them in a deck
    public void buildDeckOfHalfGoldClubs(ArrayList<Card> deck) {
        for (int i = 0, n = DECKSIZE / 2; i < n; i++) {
            deck.add(new Gold("Gold Club", "Gold"));
        }
    }
    
    // Make 26 Bear Assets and store them in a deck
    public void addToDeckTwentySixBears(ArrayList<Card> deck) {
        for (int i = 0, n = DECKSIZE / 2; i < n; i++) {
            deck.add(new LivingAsset("Bear", 10, 10));
        }
    }
        
    // Shuffle the deck
    public void shuffleDeck(ArrayList<Card> deck) {
        Collections.shuffle(deck);
    }
    
    // Deal one card from the top of the deck
    public Card dealOneCard(ArrayList<Card> deck) {
        // index 0 is just the top of the deck
    	Card oneCard = deck.get(0);
        deck.remove(0);
        return oneCard;
    }
    
    // Deal seven cards from the top of the deck
    public ArrayList<Card> dealSevenCards(ArrayList<Card> deck) {
    	ArrayList<Card> sevenCards = new ArrayList<Card>();
    	for (int i = 0, n = OPENINGHANDSIZE; i < n; i++) {
    		sevenCards.add(deck.get(i));
    	    deck.remove(i);
    	}
    	
    	return sevenCards;
    }
}