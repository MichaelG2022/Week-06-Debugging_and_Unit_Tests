package week6WarCardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	// FIELDS
	private List<Card> hand = new ArrayList<Card>();
	private int score;
	private String name;
	
	// CONSTRUCTORS
	
	// Create a player.
	public Player(String name) {
		this.setName(name);
		this.setScore(0);
	} // end Player constructor
	
	// METHODS
	
	// Get the top card (card at index 0) of each players hand, remove that card from List hand, and return the card.
	public Card flipCard() {
		Card topOfHand = hand.get(0);
		hand.remove(0);
		return topOfHand;
	} // end flipCard
	
	// Print the player name and the name and value of each card in the hand List.
	public void describePlayer(Player player) {
		System.out.println(player.getName() + " has the following cards: ");
		System.out.println("**********************************");
		for (Card c : hand) {
			System.out.println(c.describeCard(c));			
		} // end for
	} // end describePlayer
	
	// Increment score if a player wins a round.
	public void incrementScore() {
		this.score ++;
	} // end incrementScore
	
	// GETTERS AND SETTERS
	public List<Card> getHand() {
		return hand;
	}
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

} // end CLASS
