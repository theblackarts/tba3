package core;

public class Damage extends Card{
	private int damageAmount;
	public Damage(String name, int goldCost, int setdamageAmount){
		super.setCardName(name);
		super.setGoldCost(goldCost);
		this.damageAmount = setdamageAmount; 
	}
	public int damageHitPoints(Player defendingPlayer){
		return defendingPlayer.getHitPoints() - damageAmount;
	}
	
}
