package test;

import core.Player;

public class TestPlayer {

	public static void main(String[] args) {
		Player player = new Player();
		System.out.println(player);
		
		System.out.println("\nPlayer's deck is:\n");
		System.out.println(player.getDeck());	
	}

}
