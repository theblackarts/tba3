package test;

import java.util.Scanner;

import core.Game;
import core.Player;


public class TestGameMainLoop {

	public static void main(String[] args) {
		String playerOne;
		String playerTwo;
		Scanner input = new Scanner(System.in);
		
		System.out.println("** Welcome to The Dark Arts game **\n");
		System.out.print("Enter player's One Name: ");
		playerOne = input.next();
		System.out.println("");
		System.out.print("Enter player's Two Name: ");
		playerTwo = input.next();
		
		Game game = new Game(new Player(playerOne), new Player(playerTwo));
		//game.announceGame();
		game.startGame(game.getPlayerOne(), game.getPlayerTwo());

	}
}