package week6WarCardGame;

public class App {

	// INITIALIZE GLOBAL VARIABLES
	static Player playerOne = new Player("King Kong");
	static Player playerTwo = new Player("Godzilla");
	static Card card = new Card();
	static int tieCounter = 0;

	public static void main(String[] args) {

/*		HOW TO PLAY WAR CARD GAME:
 * 
 * 		OBJECTIVE:	To win all of the cards in the deck - for this program, the object is to win the most rounds
 * 						after playing one hand (26 cards for each player).
 * 
 * 		SETUP:		Two or more players - for this program, only two players are used.
 * 
 * 					Standard deck of 52 playing cards, without jokers, well shuffled.
 * 
 * 					Deal one card to each player, alternating, until each player has 26 cards for their hand.
 * 						Players are not	allowed to look at the cards in their hand, nor those of their opponent.
 * 
 * 		GAME PLAY:	Each player picks the top card of their hand of cards and flips it face up simultaneously.
 * 
 * 					The value of the cards is compared. The player with the highest value card wins the round
 * 						and gets 1 point and the cards played in that round.
 * 
 *  				Once a hand is finished, each player shuffles their cards and game play resumes with
 *  					the new hands - for this program, only one hand of cards is played.
 * 
 * 					If the cards have the same value, the round is a tie and no points are awarded.
 * 
 * 					Note:	This program has simplified game play. In the full game, when a tie occurs,
 * 							a war is declared. When a war is declared, each player will play 3 cards face down,
 * 							then a 4th card face up. The player who has the highest card wins the round and all
 * 							10 cards played in that round - for this program, war is not declared. 
 * 
 * 					Game play continues until one player has won all the cards and is declared the winner
 * 						- for this program, the player with the most points at the end of the hand is the winner.
 */

		// INITIALIZE THE DECK
		Deck deck = new Deck();

		// SHUFFLE THE DECK
		deck.shuffleTheDeck();

		// DEAL 26 CARDS ALTERNATELY TO EACH PLAYER
		for (int i= 0; i < 52; i++) {
			if (i % 2 == 0) {
				playerOne.getHand().add(deck.drawCard());
			} else {
				playerTwo.getHand().add(deck.drawCard());	
			} // end if-else
		} // end for

		// SHOW EACH PLAYER'S HAND
		playerOne.describePlayer(playerOne);
		System.out.println("\n");
		playerTwo.describePlayer(playerTwo);
		System.out.println("\n***********************************************************************************************\n");

		// DRAW 1 CARD FROM EACH PLAYER'S HAND, FLIP THE CARDS FACE UP, DISPLAY THE CARD NAME AND THE CARD VALUE.
			// COMPARE THE CARD VALUES. THE PLAYER WITH THE HIGHEST VALUE CARD WINS 1 POINT.
			// IF BOTH CARDS HAVE THE SAME VALUE, A TIE IS DECLARED AND NO POINTS ARE AWARDED.
		
		// Draw the cards and flip them face up, 26 times.
		for (int x = 0; x < 26; x++) {
			Card p1Draw = playerOne.flipCard();
			Card p2Draw = playerTwo.flipCard();

		// Give round number, player name, and describe each player's card
			System.out.print("Round " + (x + 1) + ":\t");
			System.out.println(displayPlayerAndCardDrawn(playerOne, p1Draw));
			System.out.println("\t\t" + displayPlayerAndCardDrawn(playerTwo, p2Draw));

		// Compare card values to determine the winner of the round
			
			// If player 1 wins, increment player 1 score and show as winner
			if (p1Draw.getValue() > p2Draw.getValue()) {
				announceWinnerAndIncrementScore(playerOne, "this round");
								
				// Display the current score
				displayScore("Current score: ");
				
			// If player 2 wins, increment player 2 score and show as winner
			} else if (p2Draw.getValue() > p1Draw.getValue()){
				announceWinnerAndIncrementScore(playerTwo, "this round");

				// Display the current score
				displayScore("Current score: ");
				
			// If a tie occurs
			} else {
				tieCounter++;
				System.out.println("\t\t*************************************************");
				System.out.println("\t\t*\t     This round is a tie\t\t*");
				System.out.println("\t\t*************************************************");
				
				// Display the current score
				displayScore("Current score: ");				
			} // end if-else
		} // end for
		
		// ANNOUNCE THE FINAL SCORE AND THE WINNER
		// Line separator
		System.out.println("***********************************************************************************************\n");
		
		// Determine the winner of the game
		
		// If player 1 wins the game
		if (playerOne.getScore() > playerTwo.getScore())  {
			
			// Display the final scores, including number of tie rounds
			displayScore("Final score: ");
			displayNumberOfTieRounds();
			
			// Announce playerOne as the winner
			announceWinnerAndIncrementScore(playerOne, "the game!   ");
			
		// If player 2 wins the game
		} else if (playerTwo.getScore() > playerOne.getScore()) {
			
			// Display the final scores, including number of tie rounds
			displayScore("Final score: ");
			displayNumberOfTieRounds();
			
			// Announce playerTwo as the winner
			announceWinnerAndIncrementScore(playerTwo, "the game!   ");
			
		// If the score is tied at the end of the game	
		} else {
			
			// Display the final scores, including number of tie rounds
			displayScore("Final score: ");
			displayNumberOfTieRounds();
			
			// Announce that nobody won
			System.out.println("\t\t*************************************************");
			System.out.println("\t\t*\tScore is tied! Nobody wins!\t\t*");
			System.out.println("\t\t*************************************************");
		} // end if-else
	
	} // end MAIN
	
	// METHODS OUTSIDE MAIN
	
	public static String displayPlayerAndCardDrawn(Player player, Card drawnCard) {
		 return (player.getName() + " plays:   \t" + card.describeCard(drawnCard).toString());
	} // end displayPlayerAndCardDrawn
	
	public static  void announceWinnerAndIncrementScore(Player player, String winnerType) {
		// Increments score during normal rounds only, prevents score from being incremented during final score announcement
		if (winnerType.equals("this round")) {
			player.incrementScore();
		}// end if

		// Print winner's box
		System.out.println("\t\t*************************************************");
		System.out.println("\t\t*\t    " + player .getName()+ " wins " + winnerType + "\t\t*");
		System.out.println("\t\t*************************************************");
	} // end announceRoundWinnerAndIncrementScore
	
	public static void displayScore(String scoreType) {
		System.out.println("\t\t" + scoreType+ "\t" + playerOne.getName() + ": " + playerOne.getScore()
			+ "\t" + playerTwo.getName() + ": " + playerTwo.getScore() + "\n");
	} // end displayScore
	
	public static void displayNumberOfTieRounds() {
		if (tieCounter == 1) {
			System.out.println("\t\t\t\t" + tieCounter + " tie round\n");
		} else {
			System.out.println("\t\t\t\t" + tieCounter + " tie rounds\n");
		} // end if-else
	} // end displayNumberOfTieRounds

} // end CLASS
