package test;

import core.Game;
import core.Player;


public class TestGameMainLoop {

	public static void main(String[] args) {
		Game game = new Game(new Player("Alice"), new Player("Bob"));
		
		game.announceGame();
		game.startGame(game.getPlayerOne(), game.getPlayerTwo());

	}
}