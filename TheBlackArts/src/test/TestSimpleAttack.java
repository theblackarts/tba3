package test;

import java.util.ArrayList;
import java.util.Scanner;

public class TestSimpleAttack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput;
        ArrayList<String> monsters = new ArrayList();
        monsters.add("Monster A");
        monsters.add("Monster B");
        monsters.add("Monster C");

        // Prompt the user for input
        System.out.print("Select your monsters: ");

        // Get the user input
        userInput = input.next();

        // Use string methods to extract each integer character
        String[] selectParts = userInput.split(",");

        // Validate
        for (String str : selectParts) {
            System.out.println(
                    monsters.get(Integer.parseInt(str) - 1)
            );
        }







    }
}
