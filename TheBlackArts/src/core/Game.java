package core;

import java.util.ArrayList;

public class Game {
	
	private int gameID;
	private int totalTurns;
	private int playerTurn; // Who's turn is it (1) Player One, (2) Player Two
	
    /** Each game is played by two players */
    private Player playerOne = new Player();
    private Player playerTwo = new Player();

	private boolean playerOneWin = false;
    private boolean playerTwoWin = false;

    /** Constructors */
    public Game(int gameID) {
        this.gameID = gameID;
    }
    
    public Game(int gameID, Player playerOne, Player playerTwo) {
    	this.gameID = gameID;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
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
    
    /** Announce the game! */
    public void announceGame() {
        System.out.println("** Welcome to The Dark Arts game **\n");   
    }
}