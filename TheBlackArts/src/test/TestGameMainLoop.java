package test;

import java.util.Scanner;

import core.Game;
import core.Player;


public class TestGameMainLoop {

	public static void main(String[] args) {
		String playerOne;
		String playerTwo;
		int playerOneHP;
		int playerTwoHP;
		Scanner input = new Scanner(System.in);
		
		System.out.println("** Welcome to The Dark Arts game **\n");
		System.out.print("Enter player's One Name: ");
		playerOne = input.next();
		System.out.print("Enter player's One Health Points: ");
		playerOneHP = input.nextInt();
		System.out.println("");
		System.out.print("Enter player's Two Name: ");
		playerTwo = input.next();
		System.out.print("Enter player's Two Health Points: ");
		playerTwoHP = input.nextInt();
		
		Game game = new Game(new Player(playerOne, playerOneHP), new Player(playerTwo, playerTwoHP));
		//game.announceGame();
		game.startGame(game.getPlayerOne(), game.getPlayerTwo());

	}
}