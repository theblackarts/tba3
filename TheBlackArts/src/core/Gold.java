/* Gold Cards represent the economic component of The Black Arts.
 * Gold Cards may be used to pay for the cost of Monster, Action, and Accessory cards
 * One Gold card may be played from a Player's hand each turn.
 */

package core;

public class Gold extends Card {
    
    // Data fields
    private boolean isUsed = false;

    // Constructor
    public Gold() {
        this("Gold", "Add one Gold to your Gold Pool. Gold may only be used once per turn.");
    }
    
    public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public Gold(String name, String bodyText) {
        setCardName(name);
        setCardBodyText(bodyText);
    }
}