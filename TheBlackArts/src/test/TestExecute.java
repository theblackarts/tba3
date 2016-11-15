package test;

import java.util.ArrayList;

import core.Card;
import core.Execute;
import core.Monster;

public class TestExecute {
	
	public static void main(String[] args) {
		ArrayList<Card> inPlayZone = new ArrayList<Card>();
		ArrayList<Card> deadZone = new ArrayList<Card>();
		
		inPlayZone.add(new Monster());
		inPlayZone.add(new Monster());
		inPlayZone.add(new Monster());
		
		System.out.println("\n**Before execute has been run**\n");
		System.out.println(inPlayZone);
		System.out.println(deadZone);
		
		System.out.println("\n**Run execute**\n");
		Execute execute = new Execute("Execute", 2);
		
		execute.killSelectMonster(inPlayZone, deadZone);
		
		System.out.println("\n**After execute has been run**\n");
		System.out.println(inPlayZone);
		System.out.println(deadZone);
	}

}
