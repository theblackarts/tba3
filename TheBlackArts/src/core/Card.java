/*
 * Cards represent the fundamental building blocks of
 * The Black Arts. Cards can be of three types which will be
 * defined in subclases of this superclass (TODO: Make these subclasses):
 * 
 * - Activator (resources to pay for Assets and Actions),
 * - LivingAsset (attack and defend other Living Assets or your opponent)
 * - NonLivingAsset (these cards stay on the board and have global or specific effects)
 * - Action (Actions; have an effect on the game and are either fast or slow)
 * 
 * This might be a candidate for an abstract class -- one never instantiates a Card
 * by itself - it is always a subclass.
 */

package core;

public class Card {
    
    private int cardID = -1; // Each card will eventually be uniquely identified
    private String cardName = "Default Card Name.";
    private String cardBodyText = "Default Card Body Text.";
    private String cardSet = "Default Set"; // For now, a Card may only belong to one set.
    private String[] suitList = {"Club", "Spade", "Heart", "Diamond"};
    private String suit = suitList[0];
    
    // What does it cost to activate this card?
    private int clubCost = 0;
    private int spadeCost = 0;
    private int heartCost = 0;
    private int diamondCost = 0;
    
    // Game zone the card is in
    private boolean inHandZone = false;
    private boolean inPlayZone = false;
    private boolean inDeckZone = false;
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
    
    public void setClubCost(int cost) {
        this.clubCost = cost;
    }
    
    public void setSpadeCost(int cost) {
        this.clubCost = cost;
    }
    
    public void setHeartCost(int cost) {
        this.clubCost = cost;
    }
    
    public void setDiamondCost(int cost) {
        this.clubCost = cost;
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
    
    public int getClubCost() {
        return clubCost;
    }
    
    public int getSpadeCost() {
        return spadeCost;
    }
    
    public int getHeartCost() {
        return clubCost;
    }
    
    public int getDiamondCost() {
        return clubCost;
    }
}