/*
 * Activator Cards represent the economic component of The Black Arts.
 * Activator Cards may be activated (used) to pay for the cost of Asset cards
 * and Action cards. One activator card may be played from a Player's hand each
 * turn.
 */

package core;

public class Gold extends Card {
    
    // Data fields
    private boolean isUsed = false;     // TODO: Check that gold card is inPlay
                                           //before allowing it to be used.
    private String cardType = "Gold";

    // Constructor
    public Gold() {
        
    }
    
    public Gold(String name) {
        super.setCardName(name); // Note that without a setter method, this would not be possible.
    }
    
    public Gold(String name, String suit) {
        super.setCardName(name);
        super.setSuit(suit);
    }
    
    // Setter
    public void setUsed(boolean used) {
        this.isUsed = used;
    }
    
    // Getter
    public boolean getUsed() {
        return this.isUsed;
    } 
}