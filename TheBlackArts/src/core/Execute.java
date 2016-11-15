package core;

import java.util.ArrayList;
import java.util.Scanner;

public class Execute extends Card {
	
	public Execute(String name, int goldCost) {
		super.setCardName(name);
		super.setGoldCost(goldCost);
	}
	
	// We can assign inPlayZone & deadZone's players based on the purchase phase
	public void killSelectMonster(ArrayList<Card> inPlayZone, ArrayList<Card> deadZone) {
		Scanner input = new Scanner(System.in);
		Card monster;
		
		for (int i = 0, n = inPlayZone.size(); i < n; i++) {
            if (inPlayZone.get(i) instanceof Monster) { // We know there is at least one monster
        		
            	// Prompt user to select a monster
            	System.out.println("Select one Monsters to kill");
            	
            	// Display monsters that can be selected
            	for (int j = 0; j < n; j++)
                    if (inPlayZone.get(j) instanceof Monster)
                        System.out.println((j + 1) + ": " + inPlayZone.get(j).getCardName());
            	
            	// Get the input
            	int selectMonster = input.nextInt();
            	
            	// Store the selectMonster
            	monster = inPlayZone.get(selectMonster - 1);
            	
            	// Remove the monster card from the play zone
            	inPlayZone.remove(selectMonster - 1);
            	
            	// Add the monster card to the dead zone
            	deadZone.add(monster);
            	
            	System.out.println(monster.getCardName() + " was killed!");
            	
            	break;
            }
		}
	}
}