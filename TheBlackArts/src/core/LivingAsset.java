package core;

public class LivingAsset extends Card {
    
    // Data fields
    private String cardType = "Living Asset";
    private int attack = 0;
    private int hitPoints = 1;
    private boolean isAttacked = false;
    
    // Constructors
    public LivingAsset() {
        
    }
    
    public LivingAsset(String name, int attack, int hitPoints) {
        super.setCardName(name);
        this.attack = attack;
        this.hitPoints = hitPoints;
    }
    
    public LivingAsset(int attack, int hitPoints) {
        this.attack = attack;
        this.hitPoints = hitPoints;
    }
    
    public LivingAsset(String name, int attack, int hitPoints, int clubCost) {
    	super.setCardName(name);
    	this.attack = attack;
    	this.hitPoints = hitPoints;
    	super.setClubCost(clubCost);
    }
    
    
    // Setters
    public void setAttack(int attack) {
        this.attack = attack;
    }
    
    public void sethitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    
    
    // Getters
    public int getAttack() {
        return this.attack;
    }
    
    public int getHitPoints() {
        return this.hitPoints;
    }
    
}