package core;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private int gameID;
	private int totalTurns = 0;
	private int playerTurn; // Who's turn is it (1) Player One, (2) Player Two
	
	// Game Zones
	ArrayList<Card> playerOneInPlayZone = new ArrayList<Card>();
	ArrayList<Card> playerTwoInPlayZone = new ArrayList<Card>();
	
	ArrayList<Card> playerOneDeadZone = new ArrayList<Card>();
	ArrayList<Card> playerTwoDeadZone = new ArrayList<Card>();
	
    /** Each game is played by two players */
    private Player playerOne = new Player("Alice");
    private Player playerTwo = new Player("Bob");

	private boolean playerOneWin = false;
    private boolean playerTwoWin = false;

    private Scanner input = new Scanner(System.in);
    
    /** Constructors */
    public Game(int gameID) {
        this.gameID = gameID;
    }
    
    public Game(int gameID, Player playerOne, Player playerTwo) {
    	this.gameID = gameID;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }
    
    /**
     * UI methods for a Game
     */
    // Allow player to choose a card from his or her hand
    public void simplePickOneCard(ArrayList<Card> hand) {
    	// Prompt the player which card to choose
    	System.out.println("Which card would you like to select?");
    	
    	// Display all the cards with a number
    	for (int i = 0, n = hand.size(); i < n; i++) {
    		System.out.println((i + 1) + ": " + hand.get(i));
    	}
    	
    	// Prompt player for selection
    	System.out.print("Select (enter a number): ");
        
    	// Get the selection
    	int selection = input.nextInt();
    	
    	// Output the card selected
    	System.out.println(hand.get(selection - 1));
    	
    }
    
    public void pickOneCard(ArrayList<Card> hand) {
    	// Prompt the player which card to choose
    	System.out.println("Which card would you like to select?");
    	System.out.println("HAND");
    	
    	// Display all the cards with a number
    	for (int i = 0, n = hand.size(); i < n; i++) {
    		System.out.println((i + 1) + ": " + hand.get(i).getCardName());
    	}
    	
    	// Prompt player for selection
    	System.out.print("Select (enter a number): ");
        
    	// Get the selection
    	int selection = input.nextInt();
    	
    	// Get the card
    	Card card = hand.get(selection - 1);
    	
    	// Check if the card is a Living Asset or Nonliving Asset
    	if (card instanceof LivingAsset) {
    		System.out.println("You picked " + card.getCardName());
    		System.out.println("It costs " + card.getClubCost() + " clubs (soon this will just be gold.)");
    	} else if (card instanceof Gold) {
    		System.out.println("You picked " + card.getCardName());
    	}
    }
    
    /**
     * Other Game methods
     */
    
    /** Announce the game! */
    public void announceGame() {
        System.out.println("** Welcome to The Dark Arts game **\n");   
    }
    
    
    /** Setters */
	public void setPlayerOneWin(boolean playerOneWin) {
		this.playerOneWin = playerOneWin;
	}

	public void setPlayerTwoWin(boolean playerTwoWin) {
		this.playerTwoWin = playerTwoWin;
	}

	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}

	public void setTotalTurns(int totalTurns) {
		this.totalTurns = totalTurns;
	}
    
    public int getTotalTurns() {
		return totalTurns;
	}
    
    public void setGameID(int gameID) {
    	this.gameID = gameID;
    }
    
    public void setPlayerOne(Player player) {
        this.playerOne = player;
    }
    
    public void setPlayerTwo(Player player) {
        this.playerTwo = player;
    }
    
    
    /** Getters */
    public boolean getIsPlayerOneWin() {
		return playerOneWin;
	}
    
	public boolean getIsPlayerTwoWin() {
		return playerTwoWin;
	}
    
	public int getPlayerTurn() {
		return playerTurn;
	}
	
    public int getGameID() {
    	return this.gameID;
    }
    
	public Player getPlayerOne() {
		return playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}
	
	public void nextTurn() {
		this.totalTurns++;
	}
	
	
	
}