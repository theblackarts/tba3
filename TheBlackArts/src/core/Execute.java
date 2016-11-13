package core;

import java.util.ArrayList;

public class Execute extends Card {
	
	public Execute(String name, int goldCost) {
		super.setCardName(name);
		super.setGoldCost(goldCost);
	}
	
	// should the param be a game object?
	// kill select monster in given game; if you pass it a game object you can get information
	// about who played the card?
	
	public void killSelectMonster(Game game) {
		
		if (game.getTotalTurns() % 2 == 0) {
			// Player one's turn

			// If there are no Monsters to kill, tell player 1 do not allow the card to be played
			
			// Ask which Monster to kill
			// Display a list of all of the Player 2's monsters that are in play
			System.out.println("Select a monster to kill");
			
			// Get player 2's in play monsters
			ArrayList<Card> playerTwoInPlayZone = game.getPlayerTwoInPlayZone();
			for (int i = 0, n = playerTwoInPlayZone.size(); i < n; i++) {
				if (playerTwoInPlayZone.get(i) instanceof Monster)
					System.out.println(playerTwoInPlayZone.get(i).getCardName());
			}
			
			// Store the index of the monster to kill
			
			// Remove the monster from player 2's in play zone
			
			// Add the monster to player 2's dead zone
			
			//---------As just a test, let's just remove the first monster we find-------//
			
		} else {
			// Player two's turn
		}
		
	}
}