/*
 * Cards represent the fundamental building blocks of
 * The Black Arts. Cards can be of four types which are
 * defined in subclases of this superclass.
 * 
 * - Gold (resources to pay for Monsters, Actions, and Accessories),
 * - Monster (attack and defend other Monsters or your opponent)
 * - Accessory (these cards stay on the board and have global or specific effects)
 * - Action (Actions; have an effect on the game and are either fast or slow)
 * 
 * NOTE: This might be a candidate for an abstract class -- one never instantiates a Card
 * by itself - it is always a subclass.
 */

package core;

public class Card {
    
    private int cardID; // Each card will eventually be uniquely identified
    private String cardName = "Default Card Name.";
    private String cardBodyText = "Default Card Body Text.";
    private String cardSet = "Default Set"; // For now, a Card may only belong to one set.
    private String[] suitList = {"Club", "Spade", "Heart", "Diamond"};
    private String suit = suitList[0];
    
    // What does it cost to activate this card?
    private int goldCost = 0; // This will be our "Gold" until a complete refactor of suits -> only gold
    
    // Game zone the card is in
    private boolean inHandZone = false;
    private boolean inPlayZone = false;
    private boolean inDeckZone = true;
    private boolean inDeadZone = false;
    
    // Constructors
    public Card() {
        
    }
    
    public Card(int cid) {
        this.cardID = cid;
    }
    
    public Card(int cid, String name, String body, String set) {
        this.cardID = cid;
        this.cardName = name;
        this.cardBodyText = body;
        this.cardSet = set;
    }
    
    
    // Setters
    public void setCardID(int id) {
        this.cardID = id;
    }
    
    public void setCardName(String name) {
        this.cardName = name;
    }
    
    public void setCardSet(String name) {
        this.cardSet = name;
    }
    
    public void setSuit(String suit) {
        this.suit = suit;
    }
    
    public void setGoldCost(int cost) {
        this.goldCost = cost;
    }
    
    public void setInHandZone(boolean z) {
    	this.inHandZone = z;
    }
    
    public void setInPlayZone(boolean z) {
    	this.inPlayZone = z;
    }
    
    public void setInDeckZone(boolean z) {
    	this.inPlayZone = z;
    }
    
    public void setInDeadZone(boolean z) {
    	this.inDeadZone = z;
    }
    
    
    // Getters
    public int getCardID() {
        return cardID;
    }
    
    public String getCardName() {
        return cardName;
    }
    
    public String getCardSet() {
        return cardSet;
    }
    
    public String getSuit() {
        return suit;
    }
    
    public int getGoldCost() {
        return goldCost;
    }
}