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
    
    private String cardName = "Default Card Name.";
    private String cardBodyText = "Default Card Body Text.";
    private int goldCost = 0;
    
    // Getters and setters
    public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardBodyText() {
		return cardBodyText;
	}

	public void setCardBodyText(String cardBodyText) {
		this.cardBodyText = cardBodyText;
	}

	public int getGoldCost() {
		return goldCost;
	}

	public void setGoldCost(int goldCost) {
		this.goldCost = goldCost;
	}

	// Constructors
    public Card() {

    }

    public Card(String name, String body) {
        this.cardName = name;
        this.cardBodyText = body;
    }
    
}