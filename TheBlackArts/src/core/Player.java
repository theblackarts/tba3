/*
 *  A player is the primary user of The Black Arts game.
 */

package core;

import java.util.ArrayList;

public class Player {
   
    // Data fields
    private int playerID;
    private String firstName;
    private String lastName;
    private String userName;
    private int hitPoints = 100;
    
    private ArrayList<Card> hand = new ArrayList<Card>(7);
    
    private int clubResourcePool = 0;
    private int spadeResourcePool = 0;
    private int heartResourcePool = 0;
    private int diamondResourcePool = 0;
    
    // Constructors
    public Player(){
    
    }
    
    public Player(String firstName) {
        this.firstName = firstName;
    }
    
    public Player(int id, String fname, String lname, int hp) {
        this.playerID = id;
        this.firstName = fname;
        this.lastName = lname;
        this.hitPoints = hp;
    }
    
    // Setters
    public void setPlayerID(int id) {
        this.playerID = id;
    }
    
    public void setFirstName(String name) {
        this.firstName = name;
    }
    
    public void setLastName(String name) {
        this.lastName = name;
    }
    
    public void setUserName(String name) {
        this.userName = name;
    }
    
    public void setHitPoints(int hp) {
        this.hitPoints = hp;
    }
    
    public void setClubResourcePool(int clubResourcePool) {
        this.clubResourcePool = clubResourcePool;
    }
    
    public void setSpadeResourcePool(int spadeResourcePool) {
        this.spadeResourcePool = spadeResourcePool;
    }
    
    public void setHeartResourcePool(int heartResourcePool) {
        this.heartResourcePool = heartResourcePool;
    }
    
    public void setDiamondResourcePool(int diamondResourcePool) {
        this.diamondResourcePool = diamondResourcePool;
    }
    
    // Getters
    public int getPlayerID() {
        return playerID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public int getHitPoints() {
        return hitPoints;
    }
    
    public int getClubResourcePool() {
        return clubResourcePool;
    }
    
    public int getSpadeResourcePool() {
        return spadeResourcePool;
    }
    
    public int getHeartResourcePool() {
        return heartResourcePool;
    }
    
    public int getDiamondResourcePool() {
        return diamondResourcePool;
    }
    
    public ArrayList<Card> getHand() {
        return hand;
    }
}