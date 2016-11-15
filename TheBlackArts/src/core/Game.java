/* 
 * "All that is gold does not glitter,
 * Not all those who wander are lost;
 * The old that is strong does not wither,
 * Deep roots are not reached by the frost.
 * From the ashes a fire shall be woken,
 * A light from the shadows shall spring;
 * Renewed shall be blade that was broken,
 * The crownless again shall be king."
 *  --J. R. R. Tolkein
 *
 * GL & HF, Shuffle up and deal!
 */

package core;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
		
    // Each game is played by two players
    private Player playerOne;
    private Player playerTwo;
	
	// Who's turn it is, is based on modulo 2 (0 is player 1's turn, 1 is player 2's turn)
    private int totalTurns = 0;

    // Deck Manager
    private Deck deckManager = new Deck();

    // Turn Phases
    private boolean refreshPhase;
    private boolean drawPhase;
    private boolean attackPhase;
    private boolean minePhase;
    private boolean purchasePhase;
    private boolean endPhase;

    // Game Zones
    private ArrayList<Card> playerOneInPlayZone = new ArrayList<Card>();
    private ArrayList<Card> playerTwoInPlayZone = new ArrayList<Card>();

    private ArrayList<Card> playerOneDeadZone = new ArrayList<Card>();
    private ArrayList<Card> playerTwoDeadZone = new ArrayList<Card>();
    
    // UI input
    private Scanner input = new Scanner(System.in);
    private char decideYN;
    private int cardChoice;
    private Card card;

    // FTW!
    private boolean playerOneWin = false;
    private boolean playerTwoWin = false;


    // Constructors
    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    /**
     * This method starts a game of The Black Arts.
     * Player's will alternate turns until one of them runs out of HP!
     * @param playerOne Player one
     * @param playerTwo Player two
     */
    public void startGame(Player playerOne, Player playerTwo) {

        // Get each Player's Deck
        ArrayList<Card> deckOne = playerOne.getDeck();
        ArrayList<Card> deckTwo = playerTwo.getDeck();

        // Shuffle each Player's Deck
        deckManager.shuffleDeck(deckOne);
        deckManager.shuffleDeck(deckTwo);

        // Deal Each Player's starting hand
        playerOne.setHand(deckManager.dealSevenCards(deckOne));
        playerTwo.setHand(deckManager.dealSevenCards(deckTwo));

        // Create a reference variable for each Player's hand
        ArrayList<Card> handOne = playerOne.getHand();
        ArrayList<Card> handTwo = playerTwo.getHand();

        // Main game loop that allows players to take turns until one of them goes to 0 HP.
        while (true) {
            
        	// Display the turn number (e.g. first turn is 1, second turn is 2, and so on)
            System.out.println(":: Turn :: " + (totalTurns + 1));
            
            if (totalTurns % 2 == 0) { // We know it is playerOne's turn
                // Announce that it is player one's turn
                System.out.println("It is " + playerOne.getFirstName() + "'s turn.");

                /* ========================================================
                 *              PLAYER ONE'S TURN PHASES
                 * ========================================================*/
                
                // ********************* (1) Refresh *********************
                startRefreshPhase(playerOneInPlayZone);
                
                // ********************* (2) Draw ************************
                startDrawPhase(deckOne, handOne);
               
                // ********************* (3) Attack **********************
                startAttackPhase(playerOneInPlayZone,
                                 playerTwoInPlayZone,
                                 playerOneDeadZone,
                                 playerTwoDeadZone);
                
                // ********************* (4) Mine ************************
                startMinePhase(handOne, playerOneInPlayZone);
                
                // ********************* (5) Purchase ********************
                startPurchasePhase(handOne,
                		           playerOneInPlayZone,
                		           playerTwoInPlayZone,
                		           playerTwoDeadZone);
                
                // ********************* (6) End *************************
                startEndPhase();
            
            } else if (totalTurns % 2 == 1) { // We know it is playerTwo's turn
                
            	System.out.println("It is " + playerTwo.getFirstName() + "'s turn.");

            /* ========================================================
             *              PLAYER TWO's TURN PHASES
             * ========================================================*/

            // ********************* (1) Refresh *********************
                
            	startRefreshPhase(playerTwoInPlayZone);
                
            	// ********************* (2) Draw ************************
            startDrawPhase(deckTwo, handTwo);
                
            // ********************* (3) Attack **********************
            startAttackPhase(playerTwoInPlayZone,
                             playerOneInPlayZone,
                             playerTwoDeadZone,
                             playerOneDeadZone);
                
            // ********************* (4) Mine ************************
            startMinePhase(handTwo, playerTwoInPlayZone);
            
            // ********************* (5) Purchase ********************
            startPurchasePhase(handTwo,
            		           playerTwoInPlayZone,
            		           playerOneInPlayZone,
            		           playerOneDeadZone);
            
            // ********************* (6) End *************************
            startEndPhase();
        }
        // Increment totalTurns
        nextTurn();
        }
    }
    
    /* ========================================================
     *                  UI METHODS
     * ========================================================*/

	/**
     * Allow player to choose a card from his or her hand
     */
    public void selectOneHandCard(ArrayList<Card> hand) {
        // Prompt the player which card to choose
        System.out.println("Which card would you like to select?");
        System.out.println("HAND");

        // Display all the cards with a number
        for (int i = 0, n = hand.size(); i < n; i++) {
            System.out.println((i + 1) + ": " + hand.get(i).getCardName());
        }

        // Prompt player for selection
        System.out.print("Select (enter a number): ");

        // Get the selection
        int selection = input.nextInt();

        // Get the card
        Card card = hand.get(selection - 1);

        // Check if the card is a Monster or not a Monster
        if (card instanceof Monster) {
            System.out.println("You picked " + card.getCardName());
            System.out.println("It costs " + card.getGoldCost() + " clubs (soon this will just be gold.)");
        } else if (card instanceof Gold) {
            System.out.println("You picked " + card.getCardName());
        }
    }
    
    /* ========================================================
     *                  SETTER AND GETTER METHODS
     * ========================================================*/
        
    public ArrayList<Card> getPlayerOneInPlayZone() {
    	return playerOneInPlayZone;
    }
    
    public ArrayList<Card> getPlayerTwoInPlayZone() {
    	return playerTwoInPlayZone;
    }
    
    public void setPlayerOneWin(boolean playerOneWin) {
		this.playerOneWin = playerOneWin;
	}

    public int getTotalTurns() {
		return totalTurns;
	}

	public void setTotalTurns(int totalTurns) {
		this.totalTurns = totalTurns;
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

    /* ========================================================
     *                  GAME UTILITY METHODS
     * ========================================================*/

    /**
     * Announce the game!
     */
    public void announceGame() {
        System.out.println("** Welcome to The Dark Arts game **\n");
    }

    /**
     * Count the amount of unused gold a player has in their play zone
     */
    public int calculateAmountOfUnusedGold(ArrayList<Card> inPlayZone) {
        int amountOfUnusedGold = 0;
        for (int i = 0, n = inPlayZone.size(); i < n; i++) {
            if (inPlayZone.get(i) instanceof Gold) {
                if (((Gold) inPlayZone.get(i)).isUsed() == false) {
                    amountOfUnusedGold++;
                }
            }
        }
        return amountOfUnusedGold;
    }
    
    /**
     * Remove one select card from player one's in play zone
     */
    public void removeOneFromPlayerOneInPlayZone(int card) {
    		this.playerOneInPlayZone.remove(card);
    }
    
    /**
     * Remove one select card from player two's in play zone
     */
    public void removeOneFromPlayerTwoInPlayZone(int card) {
    		this.playerTwoInPlayZone.remove(card);
    }
    
    /**
     * Add one card to player one's dead zone 
     */
    public void addCardToPlayerOneDeadZone(Card card) {
    		this.playerOneDeadZone.add(card);
    }
    
    /**
     * Add one card to player two's dead zone 
     */
    public void addCardToPlayerTwoDeadZone(Card card) {
    		this.playerTwoDeadZone.add(card);
    }

    /* ========================================================
     *                    PHASE METHODS
     * ========================================================*/

    /**
     * Start the refresh phase for a player's turn.
     * @param inPlayZone
     * Refresh Phase:
     */
    public void startRefreshPhase(ArrayList<Card> inPlayZone) {
        refreshPhase = true;
        System.out.println("Start [REFRESH PHASE]");
        
        // For each Gold card that playerOne owns, it should go from used to unused
        // For each Monster it should go from attacked to not attacked
        for (Card c : inPlayZone) {
            if (c instanceof Gold) {
                ((Gold) c).setUsed(false);
            } else if (c instanceof Monster) {
                ((Monster) c).setIsAttacked(false);
            }
        }
        // For each card that has a game mechanic that is triggered by Refresh,
        // it should have it's behavior here
        refreshPhase = false; // end refresh phase
        System.out.println("End [REFRESH PHASE]");
    }

    /**
     * Start a player's draw phase
     * @param deck
     * @param hand
     */
    public void startDrawPhase(ArrayList<Card> deck, ArrayList<Card> hand) {
        drawPhase = true; // begin draw phase
        System.out.println("Start [DRAW PHASE]");
        if (totalTurns != 0) { // if it is not the first turn then deal one card to the Player
            Card dealtCard = deckManager.dealOneCard(deck);
            hand.add(dealtCard);
            System.out.println("You drew a " + dealtCard.getCardName());
        }
        drawPhase = false; // end draw phase
        // TODO: Implement method to shuffle Dead Zone cards back into the deck when there are no more cards
        //       to draw from a Player's deck.
        System.out.println("End [DRAW PHASE]");
    }

    /**
     * Start the attack phase for a player. If a player has no Monster's in play, skip this phase.
     * @param attackerInPlayZone
     * @param defenderInPlayZone
     * @param attackerDeadZone
     * @param defenderDeadZone
     * Attack phase:
     * Start the attack phase for a player.
     */
    public void startAttackPhase(ArrayList<Card> attackerInPlayZone,
                                 ArrayList<Card> defenderInPlayZone,
                                 ArrayList<Card> attackerDeadZone,
                                 ArrayList<Card> defenderDeadZone) {

        attackPhase = true;
        System.out.println("Start [ATTACK PHASE]");
        char decideYN;
        Scanner input = new Scanner(System.in);
        
        ArrayList<Monster> attackers = new ArrayList<Monster>();
        ArrayList<Monster> availableDefenders = new ArrayList<Monster>();

        /* Check that there is at least one Monster in play for the attacker
         * If there is not at least one Monster, skip the Attack phase
         */
        for (int i = 0, n = attackerInPlayZone.size(); i < n; i++) {
            if (attackerInPlayZone.get(i) instanceof Monster) { // We know there is at least one monster

	            System.out.println("Do you wish to attack (Y/N)");
	            decideYN = input.next().charAt(0);
	            if (decideYN == 'Y' || decideYN == 'y') {
	                
	            	/* ========================================================
	                 *             ATTACK PORTION OF ATTACK PHASE
	                 * ========================================================*/
	
	                // Prompt the attacker to select the Monsters he or she would like to attack with
	                System.out.println("Select a set of Monsters to attack with (ex. 1,2; no spaces)");
	
	                // Display attacker's monsters that he or she could attack with
	                // TODO: Make this a helper method
	                for (int j = 0; j < n; j++)
	                    if (attackerInPlayZone.get(j) instanceof Monster)
	                        System.out.println((j + 1) + ": " + attackerInPlayZone.get(j).getCardName());
	
	                // Get the input
	                String attackSelectsStr = input.next();
	
	                // Parse the input
	                String[] attackSelects = attackSelectsStr.split(",");
	
	                for (String str : attackSelects) {
	                    
	                	// Toggle isAttacked for each selected monster from false to true
	                    ((Monster)attackerInPlayZone.get(Integer.parseInt(str) - 1)).setIsAttacked(true);
	                    
	                    // Display which Monsters attacked
	                    System.out.println("You attacked with " +
	                            attackerInPlayZone.get(Integer.parseInt(str) - 1).getCardName());
	                    
	                    // Add the Monsters to the attackers ArrayList
	                    Monster myAttackMonster = ((Monster) attackerInPlayZone.get(Integer.parseInt(str) - 1));
	                    attackers.add(myAttackMonster);
	                }  
	
	                /* ========================================================
	                 *                 DEFENSE PORTION OF ATTACK PHASE
	                 * ========================================================*/
	
	                /* check that there is at least one monster in play for the defender
	                   If there is not at least one monster, skip the defense portion of the attack phase */
	                for (Card card1 : defenderInPlayZone) {
	                    if (card1 instanceof Monster) {
	                        for (Card card2 : defenderInPlayZone) {
	                            if (card2 instanceof Monster) {
	                                Monster myDefendMonster = ((Monster) card2);
	                            	availableDefenders.add(myDefendMonster);
	                            }
	                        }
	                        
	                        /* ------------------------------------------------------------------------
	                         * Print out the columns of the Attackers and Potential Defenders
	                         * ------------------------------------------------------------------------ */
	
	                        // Print the header
	                        System.out.format("%-20s%s\n", "Attackers:", "Avail. Defenders:");
	
	                        // Determine which of the two ArrayLists are longer
	                        if (attackers.size() > availableDefenders.size()) { // attackers is the bigger ArrayList
	                            for (int j = 0, as = attackers.size(); j < as; j++) {
	                                System.out.format("%s %-18s", j, attackers.get(j).getCardName());
	                                if (j >= 0 && j < availableDefenders.size()) {
	                                    System.out.println((j + 1) + " " + availableDefenders.get(j).getCardName());
	                                } else {
	                                    System.out.println();
	                                }
	                            }
	                        } else { // availableDefenders is the bigger ArrayList
	                            for (int k = 0, ads = availableDefenders.size(); k < ads; k++) {
	                                if (k >= 0 && k < attackers.size()) {
	                                    System.out.format("%s %-18s", k + 1, attackers.get(k).getCardName());
	                                } else {
	                                    System.out.format("%-20s", "");
	                                }
	                                System.out.println((k + 1) + " " + availableDefenders.get(k).getCardName());
	                            }
	                        }
	                        break; // since we found one monster for the defender, break out of this loop as
	                               // it has served its purpose
	                    }
	                }
	                
	        		ArrayList<String> myDefendString = new ArrayList<String>();
	        		 
	        		String defendString;
	        		String defendChoice="";
	        		
	        		System.out.println("Do you wish to defend (Y/N)");
	        		decideYN = input.next().charAt(0); 
	        		if(decideYN == 'Y' || decideYN == 'y' ) {
	        			System.out.println("How do you want to Defend");
	        			defendString = input.next();
	        			for (i = 0; i < defendString.length(); i++) {
	        				if (Character.isDigit(defendString.charAt(i)) || defendString.charAt(i) == ',') {
	        					defendChoice += defendString.charAt(i);
	        				}
	        				if (defendString.charAt(i)==')') {
	        					myDefendString.add(defendChoice);
	        					defendChoice = "";
	        				}
	        			}
	        			
	        			ArrayList<Integer> myDefendIntegerArray = new ArrayList<Integer>();
	        			String strToInt =""; 
	        			for (int j = 0; j < myDefendString.size(); j++ ) {
	        				for (int t = 0; t < myDefendString.get(j).length(); t++) {
	        					if (Character.isDigit(myDefendString.get(j).charAt(t))) {
	        						strToInt +=  myDefendString.get(j).charAt(t);
	        					}
	        					if (myDefendString.get(j).charAt(t) == ',' || t == (myDefendString.get(j).length() - 1)) {
	        						myDefendIntegerArray.add(Integer.parseInt(strToInt));
	        						strToInt = "";
	        					}
	        				}
	        				
	        				int currentAttack = attackers.get(myDefendIntegerArray.get(0) - 1).getAttack();
	        				int currentAttackHP = attackers.get(myDefendIntegerArray.get(0) - 1).getHitPoints();
	        				int currentDefenseHP;
	        				int	currentDefenseAttack;
	        				
	        				for (int f = 1; f < myDefendIntegerArray.size(); f++) {

	        					currentDefenseAttack = availableDefenders.get(myDefendIntegerArray.get(f) - 1).getAttack();
	        					currentDefenseHP = availableDefenders.get(myDefendIntegerArray.get(f) - 1).getHitPoints();
	        					currentAttackHP -=  currentDefenseAttack;
	        					currentDefenseHP -= currentAttack; 
	        					
	        					if (currentDefenseHP <= 0) {
	        						availableDefenders.get(myDefendIntegerArray.get(f) - 1).setHitPoints(0);	
	        						currentAttack = (-1 * currentAttackHP);
	        					}	
	        				}	
	        				attackers.get(myDefendIntegerArray.get(0) - 1).setHitPoints(currentAttackHP);
	        				myDefendIntegerArray.clear();
	        				System.out.println("");
	        			}
	        			for (int f = 0; f < attackers.size(); f++) {
	        				if ((attackers.get(f).getHitPoints()) <= 0) {
	        					attackerDeadZone.add(attackers.get(f));
	        					attackerInPlayZone.remove(attackerInPlayZone.indexOf(attackers.get(f)));
	        				}
	        			}
	        			for (int f = 0; f < availableDefenders.size(); f++) {
	        				if ((availableDefenders.get(f).getHitPoints()) <= 0) {
	        					defenderDeadZone.add(availableDefenders.get(f));
	        					defenderInPlayZone.remove(defenderInPlayZone.indexOf(availableDefenders.get(f)));
	        				}
	        			}
	        		}
	        		else
	        			System.out.println("Defend phase over");
            }
	        System.out.println("Defend phase over");
        }
            
        System.out.println("** TEST OUTPUT **");
        System.out.println(attackerInPlayZone);
        System.out.println(defenderInPlayZone);
        System.out.println(attackerDeadZone);
        System.out.println(defenderDeadZone);
        
        }
        attackPhase = false;
        System.out.println("End [ATTACK PHASE]");
    }
    
    /**
     * Start the mine phase for a player, allowing that player to play one gold card (if they have one) from their
     * hand into their play zone.
     * @param hand
     * @param inPlayZone
     */
    public void startMinePhase(ArrayList<Card> hand, ArrayList<Card> inPlayZone) {
        Card card; // used for storing a card selected by a player (remove the card, add the card, print the card)
        System.out.println("Start [MINE PHASE]");
        
        /* For each card in Player One's hand, is there at least one Gold card?
         * If yes, give the Player an option to play it and stop checking for Gold cards
         * NOTE: There is no way to bluff using this system
         */
        for (int i = 0, n = hand.size(); i < n; i++) {
            card = hand.get(i);
            if (card instanceof Gold) {
                System.out.println("You have a Gold card to play, would you like to play it? Y/N: ");
                decideYN = input.next().charAt(0);
                if (decideYN == 'Y') {
                    
                	// Remove the card from a Player's hand
                    hand.remove(i);
                    
                    // Add the card to play zone
                    inPlayZone.add(card);
                    
                    break;
                }
            }
        }
        minePhase = false; // end minePhase
        System.out.println("End [MINE PHASE]");
    }

    /**
     * Start the purchase phase for a player, allowing them to purchase an
     * arbitrary number of cards, subject to the amount of unused gold they have available.
     * @param hand
     * @param inPlayZone
     */
    public void startPurchasePhase(ArrayList<Card> hand, ArrayList<Card> inPlayZone,
    		ArrayList<Card> inSelectPlayZone, ArrayList<Card> deadZone) {

    	/*
    	 * We need a way to handle the purchase of Action cards differently than
    	 * Monster cards. Action cards are basically an object with a method that
    	 * affects the state of the game -- for instance killing a monster
    	 * If purchase action card, and that action card is say execute,
    	 * we need to run the kill monster method.
    	 * 
    	 * Also, this code is getting really procedural, it would be easier to read
    	 * if we refactored the parts of it that repeat.
    	 */
    	purchasePhase = true;
    	System.out.println("Start [PURCHASE PHASE]");
        
        // Get the amount of gold that the player has at the start of his
    	// or her purchase phase
        int amountOfUnusedGold = calculateAmountOfUnusedGold(inPlayZone);
        
        int cardCost;
        boolean isAtLeastOneAffordable = false;
        
        // While player has at least 1 or more unused Gold in play run through the purchase loop
        while (amountOfUnusedGold > 0) {
        	
        	// Check that there is at least one affordable card
        	for (Card card : hand)
            	if (card.getGoldCost() <= amountOfUnusedGold && !(card instanceof Gold)) { // Added <= instead of <, can revert back if this doesnt work
            		isAtLeastOneAffordable = true;
            		break; // Added this break to make it a lazy evaluation
            	}
            
        	// If there is at least one affordable purchasebale card allow player to purchase it
        	if (isAtLeastOneAffordable) {
        		
        		/* For each card in Player's hand that has a cost (Monster, Action, Accessory),
            	 * display it along with an integer value that will act as an affordance to select
            	 * and pay for it, allowing the player to bring a card into play.
            	 */
            	for (int i = 0, n = hand.size(); i < n; i++) {
                    if (hand.get(i) instanceof Monster   ||
                    	hand.get(i) instanceof Accessory ||
                    	hand.get(i) instanceof Execute) {
                        	System.out.println((i + 1) + ": " + hand.get(i).getCardName() + ", " +
                                hand.get(i).getGoldCost());
                    }
                }
            	
                // Check if there are no purchaseable (Monster, Action, Accessory cards in hand, break
                if (!isAPurchaseableInHand(hand)) {
                    break;
                }
                
                // Prompt the user for input
                System.out.print("Pick a card by typing the associated integer value: ");
                
                // Get the Player's card choice
                boolean check = false;
                while (check == false) {
                	try {
                		cardChoice = input.nextInt();
                		check = true;
                	} catch (InputMismatchException e) {
                		System.out.println("Please input an integer value");
                		input.nextLine();
                	}
                }
                
                // Store the card in a variable that the Player selected
                card = hand.get(cardChoice - 1); // Subtract one to account for 0 index
                
                // Store the card cost
                cardCost = card.getGoldCost();

                // Does the player have enough unused gold to purchase the selected card?
                if (cardCost <= amountOfUnusedGold) {
                    
                	// Hey, you owe the game some GOLD! Pay this off!!
                    int unpaidAmount = cardCost;
                    
                    // Pay for the card
                    for (int i = 0, n = inPlayZone.size(); i < n && unpaidAmount != 0; i++) {
                        if (inPlayZone.get(i) instanceof Gold) {
                            if (!((Gold) inPlayZone.get(i)).isUsed()) {
                            	
                                // Set the gold card from used is false to used is true
                                ((Gold) inPlayZone.get(i)).setUsed(true);
                                
                                unpaidAmount--; // Now you owe us less, does your wallet feel lighter?
                            }
                        }
                    }
                    
                    // Update value of amountOfUnusedGold (important for while loop to work)
                    amountOfUnusedGold = calculateAmountOfUnusedGold(inPlayZone);
                    
                    // Remove the paid for card from the player's hand
                    hand.remove(card);
                    
                    // Case when it is a monster
                    if (card instanceof Monster) {
                    	// Add the paid for card to the player's play zone
                        inPlayZone.add(card);
                        
                        // We'll need to check again, now that we have purchased something if we can still afford anything
                        isAtLeastOneAffordable = false;
                        
                        System.out.println("You played a " + card.getCardName() + " to your play zone.");
                    // Case when it is an Action Card Execute
                    } else if (card instanceof Execute) {
                    	((Execute) card).killSelectMonster(inSelectPlayZone, deadZone);
                    }
                } else { // Player does not have enough unused gold to pay for the card
                    System.out.println("You do not have enough unused gold to pay for " + card.getCardName());
                    break;
                }
            } else {
            	break;
            }
        }
        
        // Print all cards in the player's play zone
        System.out.println("The following are the cards you have in play: ");
        for (Card card : inPlayZone)
        	System.out.println(card.getCardName());
        
        // End the purchase phase
        purchasePhase = false;
        System.out.println("End [PURCHASE PHASE]");
    }

    /**
     * Helper method for startPurchasePhase method
     * @param hand
     * @return
     */
    private boolean isAPurchaseableInHand(ArrayList<Card> hand) {
        
    	boolean yesAtLeastOnePurchaseable = false;
        
    	for (int i = 0, n = hand.size(); i < n; i++)
            if (hand.get(i) instanceof Monster || hand.get(i) instanceof Execute || hand.get(i) instanceof Accessory)
                yesAtLeastOnePurchaseable = true;
        
    	return yesAtLeastOnePurchaseable;
    }

    /**
     * Start the end phase for a player's turn.
     */
    public void startEndPhase() {
        
    	endPhase = true;

        // TODO: Implement a mechanism to allow player to discard down to 7 cards (this is the max hand size for a game)
        System.out.println("Start [END PHASE]");

        // Give player one the option to pass his or her turn
        do {
            System.out.print("Would you like to pass your turn? (Y/N):");
            decideYN = input.next().charAt(0); // VALIDATE that this is working as intended, getting one char
        } while (decideYN != 'Y');

        endPhase = false;
        System.out.println("End [END PHASE]");
    }
    
    /**
     * Increment the number of total turns for a game
     */
    public void nextTurn() {
        this.totalTurns++;
    }
}