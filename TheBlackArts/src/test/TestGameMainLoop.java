package test;

import core.Game;
import core.Player;


public class TestGameMainLoop {

	public static void main(String[] args) {
		Game game = new Game(123);
		
		game.startGame(new Player("Alice"), new Player("Bob"));

	}
}

// Test commit 4