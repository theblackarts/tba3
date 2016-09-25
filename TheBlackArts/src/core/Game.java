package core;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private int gameID;
	private int totalTurns = 0; // Who's turn it is, is based on modulo 2 (0 is player 1, 1 is player 2)
	
	// Deck Manager
	Deck deckManager = new Deck();
	
	// Turn Phases
	private boolean refreshPhase;
	private boolean drawPhase;
	private boolean attackPhase;
	private boolean minePhase; // This is when a player can play one gold card each turn
	private boolean purchasePhase;
	private boolean endPhase;
	
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

    private Scanner input = new Scanner(System.in); // useful for text based UI
    
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
     * Main game loop
     */
    public void startGame(Player playerOne, Player playerTwo) {
    	System.out.println("Game ID: " + this.getGameID());
    	
    	// Get each Player's Deck
    	ArrayList<Card> deckOne = playerOne.getDeck();
    	ArrayList<Card> deckTwo = playerTwo.getDeck();
    	
    	// Shuffle each Player's Deck
    	deckManager.shuffleDeck(deckOne);
    	deckManager.shuffleDeck(deckTwo);
    	
    	// Deal Each Player's starting hand
    	playerOne.setHand(deckManager.dealSevenCards(deckOne));
    	playerTwo.setHand(deckManager.dealSevenCards(deckTwo));
    	
    	// There needs to be some sort of loop that allows players to take turns until one of them goes to 0 HP
        while (!playerOneWin || !playerTwoWin) {

        	// Announce that it is player one (two)'s turn
        	if (totalTurns % 2 == 0) {
        		System.out.println("It is " + playerOne.getFirstName() + "'s turn."); // everything in here for Player
        																			  // One's turn?
        	} else if (totalTurns % 2 == 1) {
        		System.out.println("It is " + playerTwo.getFirstName() + "'s turn."); // and everything here for Player
        		  																      // Two's turn?
        	} else {
        		System.out.println("playerTurn variable is broken; FIX!"); 
        	}
        	
        	// Display the turn number (e.g. first turn is 1, second turn is 2, and so on)
        	System.out.println(":: Turn :: " + (totalTurns + 1));

        	// Go through all the phases of a player's turn
        	
        	// ** (1) Refresh **
        	refreshPhase = true;
        	
        	// For each Gold card, it should go from used to unused
        	
        	// For each Living Asset (Monster) it should go from attacked to not attacked
        	
        	// For each card that has a game mechanic that is triggered by Refresh, it should have it's behavior here
        	
        	refreshPhase = false;
        	
        	// ** (2) Draw **
        	
        	drawPhase = true;
        	if (totalTurns != 0) {
        		if (totalTurns % 2 == 0) {
        			// deal from deck one to player one
        		} else if (totalTurns % 2 == 1) {
        			// deal from deck two to player two
        		} else {
        			System.out.println("Draw phase is broken. FIX!");
        		}
        		
        	}
        	
        	drawPhase = false;
        	
        	// ** (3) Attack **
        	
        	// ** (4) Mine ** <-- start with this Phase and then work backwards
        	
        	// ** (5) Purchase **
        	
        	// ** (6) End **
        	
        	// Give player one the option to pass his or her turn
        	char decideYN;
        	do {
        		System.out.print("Would you like to pass your turn? (Y/N):");
            	decideYN = input.next().charAt(0); // VALIDATE that this is working as intended, getting one char
        	} while (decideYN != 'Y');
        	
        	// Increment totalTurns
        	nextTurn();
        }
    }
    
    
    /**
     * UI methods for a Game
     */
    // Allow player to choose a card from his or her hand
    public void selectOneHandCard(ArrayList<Card> hand) {
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