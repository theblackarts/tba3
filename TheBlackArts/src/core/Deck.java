/*
 * Each player in The Black Arts has one deck made of 52 cards.
 * Decks may be shuffled and dealt from. If a player runs out of cards,
 * his or her DeadZone cards are shuffled back into his or her Deck.
 */
package core;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    
    // Data fields
    private String deckName;
    private ArrayList<Card> deck;
    public static final int DECKSIZE = 52; // A deck is made up of 52 cards

    // Constructors
    public Deck() {
        
    }
    
    public Deck(String name) {
    	this.deckName = name;
    }
    
    
    /**
     * Create a deck of half Gold cards and half Bear cards used for testing
     * and development purposes.
     * @param deckName
     * @return
     */
    public ArrayList<Card> buildDeckOfHalfGoldAndHalfBears(String deckName) {
    	
    	deck = new ArrayList<Card>(DECKSIZE);
    	this.deckName = deckName;
    	
    	// Half the deck is made of Gold cards
    	for (int i = 0, n = DECKSIZE / 2; i < n; i++) {
            deck.add(new Gold());
        }
        
    	// The other half of the deck is made of Bear Cards
        for (int i = 0, n = DECKSIZE / 2; i < n; i++) {
            deck.add(new Monster("Bear", 10, 10, 2));
        }
        return deck;
    }
    
    public ArrayList<Card> buildTestDeck() {
    	
    		deck = new ArrayList<Card>(DECKSIZE);

        for (int i = 0, n = 20; i < n; i++) {
            deck.add(new Gold());
        }
        
      // The other half of the deck is made of Bear Cards
        for (int i = 0, n = 20; i < n; i++) {
            deck.add(new Monster("Bear", 10, 10, 2));
        }
        
        for (int i = 0, n = 12; i<n; i++){
          deck.add(new Execute("execute",2));
        }
        return deck;
    }

    public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	/**
     * Shuffle the deck
     * @param deck
     */
    public void shuffleDeck(ArrayList<Card> deck) {
        Collections.shuffle(deck);
    }

    /**
     * Deal one card off the top of the deck.
     * @param deck
     * @return
     */
    public Card dealOneCard(ArrayList<Card> deck) {
        
    	Card oneCard = deck.get(0); // index 0 is just the top of the deck
        deck.remove(0);
        return oneCard;
    }

    /**
     * Deal seven cards off the top of the deck.
     * @param deck
     * @return seven cards
     */
    public ArrayList<Card> dealSevenCards(ArrayList<Card> deck) {
    	ArrayList<Card> sevenCards = new ArrayList<Card>();
    	for (int i = 0, n = Player.OPENINGHANDSIZE; i < n; i++) {
    		Card oneCard = deck.get(i);
    		deck.remove(i);
    		sevenCards.add(oneCard);
    	}
    	 return sevenCards;
    }
}