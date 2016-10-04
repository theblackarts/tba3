package core;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private int gameID;
    private int totalTurns = 0; // Who's turn it is, is based on modulo 2 (0 is player 1, 1 is player 2)

    // Deck Manager
    private Deck deckManager = new Deck();

    // Turn Phases
    private boolean refreshPhase;
    private boolean drawPhase;
    private boolean attackPhase;
    private boolean minePhase; // This is when a player can play one gold card each turn
    private boolean purchasePhase;
    private boolean endPhase;

    // Game Zones
    private ArrayList<Card> playerOneInPlayZone = new ArrayList<Card>();
    private ArrayList<Card> playerTwoInPlayZone = new ArrayList<Card>();

    private ArrayList<Card> playerOneDeadZone = new ArrayList<Card>();
    private ArrayList<Card> playerTwoDeadZone = new ArrayList<Card>();

    /**
     * Each game is played by two players
     */
    private Player playerOne;
    private Player playerTwo;

    private boolean playerOneWin = false;
    private boolean playerTwoWin = false;

    private Scanner input = new Scanner(System.in); // useful for text based UI

    /**
     * Constructors
     */
    public Game(int gameID) {
        this.gameID = gameID;
    }

    public Game(int gameID, Player playerOne, Player playerTwo) {
        this.gameID = gameID;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    /**
     * @param playerOne Player one
     * @param playerTwo Player two
     */
    public void startGame(Player playerOne, Player playerTwo) {
        System.out.println("Game ID: " + this.getGameID());

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

        char decideYN; // UI input for YN
        int cardChoice; // used for UI input for picking a card via an integer value
        Card card; // used for storing a card selected by a player (remove the card, add the card, print the card)

        // Main game loop that allows players to take turns until one of them goes to 0 HP.

        while (true) {
            // Display the turn number (e.g. first turn is 1, second turn is 2, and so on)
            System.out.println(":: Turn :: " + (totalTurns + 1));

            if (totalTurns % 2 == 0) { // We know it is playerOne's turn
                // Announce that it is player one's turn
                System.out.println("It is " + playerOne.getFirstName() + "'s turn.");

                // Go through all the phases of player one's turn

                // ********************* (1) Refresh *********************

                startRefreshPhase(playerOneInPlayZone);

                // ********************* (2) Draw *********************
                drawPhase = true; // begin draw phase
                System.out.println("Start [DRAW PHASE]");
                if (totalTurns != 0) { // if it is not the first turn then deal one card to the Player
                    Card dealtCard = deckManager.dealOneCard(deckOne);
                    handOne.add(dealtCard);
                    System.out.println(playerOne.getFirstName() + ", you drew a " + dealtCard.getCardName());
                }
                drawPhase = false; // end draw phase
                // TODO: Implement method to shuffle Dead Zone cards back into the deck when there are no more cards
                //       to draw from a Player's deck.
                System.out.println("End [DRAW PHASE]");

                // ********************* (3) Attack *********************
                attackPhase = true; // start attack phase
                System.out.println("Start [ATTACK PHASE]");

                attackPhase = false; // end attack phase
                System.out.println("End [ATTACK PHASE]");

                // ********************* (4) Mine *********************

                startMinePhase(handOne);

                // ********************* (5) Purchase *********************

                startPurchasePhase(handOne);
                // Display what cards are in play for player one
                System.out.println(playerOneInPlayZone);

                // ********************* (6) End *********************
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

            } else if (totalTurns % 2 == 1) { // We know it is playerTwo's turn
                System.out.println("It is " + playerTwo.getFirstName() + "'s turn.");

                // TODO Phases here
                System.out.println("All of player two's phases");

                do {
                    System.out.print("Would you like to pass your turn? (Y/N):");
                    decideYN = input.next().charAt(0); // VALIDATE that this is working as intended, getting one char
                } while (decideYN != 'Y');

            } else {
                System.out.println("playerTurn variable is broken; FIX!");
            }

            // Increment totalTurns
            nextTurn();
        }
    }

    // UI methods for a Game

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

        // Check if the card is a Living Asset or Nonliving Asset
        if (card instanceof Monster) {
            System.out.println("You picked " + card.getCardName());
            System.out.println("It costs " + card.getGoldCost() + " clubs (soon this will just be gold.)");
        } else if (card instanceof Gold) {
            System.out.println("You picked " + card.getCardName());
        }
    }

    // Game Utility Methods

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
                if (((Gold) inPlayZone.get(i)).getUsed() == false) {
                    amountOfUnusedGold++;
                }
            }
        }
        return amountOfUnusedGold;
    }

    // Game phase methods

    public void startMinePhase(ArrayList<Card> hand) {
        minePhase = true;
        char decideYN; // UI input for YN
        int cardChoice; // used for UI input for picking a card via an integer value
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
                    // Remove the card fro Player's hand
                    hand.remove(i);
                    // Switch inHandZone to false
                    card.setInDeckZone(false);
                    // Add the card to play zone
                    playerOneInPlayZone.add(card);
                    // Switch inPlayZone to true
                    card.setInPlayZone(true);
                    break;
                }
            }
        }
        minePhase = false; // end minePhase
        System.out.println("End [MINE PHASE]");
    }

    /**
     * @param hand Purchase phase allows a player to purchase cards with his or her gold
     */
    public void startPurchasePhase(ArrayList<Card> hand) {
        char decideYN; // UI input for YN
        int cardChoice; // used for UI input for picking a card via an integer value
        Card card; // used for storing a card selected by a player (remove the card, add the card, print the card)

        purchasePhase = true; // start purchase phase
        System.out.println("Start [PURCHASE PHASE]");

        // Get the amount of gold that the player has at the start of his or her purchase phase
        int amountOfUnusedGold = calculateAmountOfUnusedGold(playerOneInPlayZone);
        int cardCost;

        while (amountOfUnusedGold > 0) {
            /* For each card in Player's hand that has a cost (Monster, Action, Accessory),
             * display it along with an integer value that will act as an affordance to select
             * and pay for it, to bring the card into play.
             */

            // Display all cards that can be purchased with an associated integer value
            // NOTE: The numbers may not be sequential because we skip Gold cards
            // Make this a method
            for (int i = 0, n = hand.size(); i < n; i++) {
                if (hand.get(i) instanceof Monster || hand.get(i) instanceof Accessory
                        || hand.get(i) instanceof Action) {
                    System.out.println((i + 1) + ": " + hand.get(i).getCardName() + ", " +
                            hand.get(i).getGoldCost()); // For now Gold Clubs will be a stand in for "Gold"
                }
            }

            // Prompt the user for input
            System.out.print("Pick a card by typing the associated integer value: ");
            // Get the Player's card choice
            cardChoice = input.nextInt();
            // Store the card in a variable that the Player selected
            card = hand.get(cardChoice - 1); // Subtract one to account for 0 index
            // Store the card cost
            cardCost = card.getGoldCost();

            int unpaidAmount = cardCost;

            // Does the player have enough unused gold to purchase the selected card?
            if (cardCost <= amountOfUnusedGold) {
                // Pay for the card
                for (int i = 0, n = playerOneInPlayZone.size(); i < n && unpaidAmount != 0; i++) {
                    if (playerOneInPlayZone.get(i) instanceof Gold) {
                        if (((Gold) playerOneInPlayZone.get(i)).getUsed() == false) {
                            // Set the gold card from used is false to used is true
                            ((Gold) playerOneInPlayZone.get(i)).setUsed(true);
                            unpaidAmount--;
                        }
                    }
                }

                // Update value of amountOfUnusedGold (important for while loop to work)
                amountOfUnusedGold = calculateAmountOfUnusedGold(playerOneInPlayZone);
                // Remove the paid for card from the player's hand
                hand.remove(card);
                // Change the card hand zone to false
                card.setInHandZone(false);
                // Add the paid for card to the player's play zone
                playerOneInPlayZone.add(card);
                System.out.println("You played a " + card.getCardName() + " to your play zone.");
                // Change the card play zone to true
                card.setInPlayZone(true);

            // Why doesn't this stop the while loop? Is it because it is breaking out of the if block?
            } else { // They do not have enough unused gold to pay for the card
                    System.out.println("You do not have enough unused gold to pay for " + card.getCardName());
                    break;
            }
        }
        purchasePhase = false; // end purchase phase
        System.out.println("End [PURCHASE PHASE]");
    }

    /**
     * Start and end the refresh phase of a player's turn
     */
    public void startRefreshPhase(ArrayList<Card> inPlayZone) {
        refreshPhase = true;
        System.out.println("Start [REFRESH PHASE]");
        // For each Gold card that playerOne owns, it should go from used to unused
        // For each Monster (to be renamed Monster) it should go from attacked to not attacked
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
     * Setters
     */
    public void setPlayerOneWin(boolean playerOneWin) {
        this.playerOneWin = playerOneWin;
    }

    public void setPlayerTwoWin(boolean playerTwoWin) {
        this.playerTwoWin = playerTwoWin;
    }

    public void setTotalTurns(int totalTurns) {
        this.totalTurns = totalTurns;
    }

    public int getTotalTurns() {
        return totalTurns;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void setPlayerOne(Player player) {
        this.playerOne = player;
    }

    public void setPlayerTwo(Player player) {
        this.playerTwo = player;
    }

    /**
     * Getters
     */
    public boolean getIsPlayerOneWin() {
        return playerOneWin;
    }

    public boolean getIsPlayerTwoWin() {
        return playerTwoWin;
    }

    public int getGameID() {
        return this.gameID;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void nextTurn() {
        this.totalTurns++;
    }
}