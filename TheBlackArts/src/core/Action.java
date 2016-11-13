package core;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Spring;

public class Action extends Card {
  public Scanner input = new Scanner(System.in);
  private Game game = new Game(null,null);
  //private ArrayList<Card> playerTwoInPlayZone = new ArrayList<Card>();
  //ArrayList<Card> availableDefenders = new ArrayList<Card>();
  private int damage;
  private int heal;
  private boolean isUsed = false;
  
  public Action() {
    
  }
  
  public Action(String name, int goldCost){
     super.setCardName(name);
     super.setGoldCost(goldCost);

    //execute();
  

   }
  
  public Action(String name, int damage,int goldCost){
    super.setCardName(name);
    this.damage = damage;
    super.setGoldCost(goldCost);
  }
  
  public Action(String name, int damage, int heal, int goldCost){
    super.setCardName(name);
    this.damage = damage;
    this.heal = heal;
    super.setGoldCost(goldCost);
  }
  


  /*public fastAction(String name, int attack){
    super.setCardName(name);
    this.attack = attack;
    
  }
  
  public fastAction(String name, int attack, int goldCost){
    super.setCardName(name);
    this.attack = attack;
    super.setGoldCost(goldCost);
  }
  
  
  public slowAction(String name, int attack){
    super.setCardName(name);
    this.attack = attack;
    
  }
  
  public slowAction(String name, int attack, int goldCost){
    super.setCardName(name);
    this.attack = attack;
    super.setGoldCost(goldCost);
  }
  */
  
  //setter
  public void setDamage(int damage) {
        this.damage = damage;
    }
  
  public void setHeal(int heal){
    this.heal = heal;
  }
  
  public void setUsed(boolean used) {
    this.isUsed = used;
    }
  
  
  
  //getter
   public int getDamage() {
     return this.damage;
      }
   
   public int getHeal(int heal){
    return this.heal;
    }
   
   public boolean getUsed() {
       return this.isUsed;
      } 
  // TODO: Implement action class

   
   public void execute(){
     int turn = game.getTotalTurns();    
     boolean cardtype = false;
     
     if(turn % 2 == 0){//this action card will attack playerTwo
       ArrayList<Card> inPlayZone = new ArrayList<Card>();
       for(Card card : inPlayZone/*I want here to be play2's playzone*/){
         System.out.println("test"+card.getCardName());
       }
       do
       {
         System.out.println("select a card: ");
         int select = input.nextInt();//select one card that you want to remove
    
      if(inPlayZone.get(select) instanceof Monster){
         cardtype = true;
         inPlayZone.remove(select);
         //inDeadZone.add(select);
       }
       else{
         System.out.println("please select a monster card.");
       }
       }while(cardtype==false);
     }
     else if(turn% 2 == 1){
       
     }while(true);

   }
   
}