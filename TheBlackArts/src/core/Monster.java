package core;

public class Monster extends Card {
    
    // Data fields
    private String cardType = "Monster";
    private int attack = 0;
    private int hitPoints = 1;
    private boolean isAttacked = false;
    
    // Constructors
    public Monster() {
        
    }
    
  //test 2
    
    public Monster(String name, int attack, int hitPoints) {
        super.setCardName(name);
        this.attack = attack;
        this.hitPoints = hitPoints;
    }
    
    public Monster(int attack, int hitPoints) {
        this.attack = attack;
        this.hitPoints = hitPoints;
    }
    
    public Monster(String name, int attack, int hitPoints, int goldCost) {
    	super.setCardName(name);
    	this.attack = attack;
    	this.hitPoints = hitPoints;
    	super.setGoldCost(goldCost);
    }
    
    
    // Setters
    public void setAttack(int attack) {
        this.attack = attack;
    }
    
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setIsAttacked(boolean isAttacked) {
        this.isAttacked = isAttacked;
    }
    
    // Getters
    public int getAttack() {
        return this.attack;
    }
    
    public int getHitPoints() {
        return this.hitPoints;
    }
    
}