package week6WarCardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	// FIELDS
	private List<Card> deck = new ArrayList<Card>();
	private String[] cardValueName = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	private String[] cardSuit = {"Clubs", "Diamonds", "Hearts", "Spades"};
	
	// CONSTRUCTORS
	
	// Create and initialize a deck
		//Set values and card names in the deck List for all 52 cards in two nested loops using the String arrays above.
		// The index to get the card value name (2 = two, 3 = three, etc.) from the cardValueName Array is obtained by
			//	subtracting 2 from int v in the outer loop.
		// The card value is set by int v in the outer loop, which increments from 2 through 14 for each card.
		// The index to get the card suit from the cardSuit Array is int s in the inner loop.
		// The card value name and card suit are concatenated to create and set the name of each card.
		// Each card is then added to the deck List.
	public Deck() {
		for (int v = 2; v < 15; v++) {
			for (int s = 0; s < cardSuit.length; s++) {
				Card c = new Card();
				c.setValue(v);
				c.setName(cardValueName[v - 2] + " of " + cardSuit[s]);
				deck.add(c);
			} // end inner for
		} // end outer for
	} // end Deck constructor
	
	// METHODS

	// Shuffle the deck
	public void shuffleTheDeck() {
		Collections.shuffle(deck);
	} // end shuffleTheDeck
	
	// Draw the top card (card at index 0 in the deck List), remove that card from the deck List,
		// then return that card. Used to split the full deck into two hands of 26 for each player.
	public Card drawCard() {
		Card topOfDeck = deck.get(0);
		deck.remove(0);
		return topOfDeck;
	} // end drawCard
		
	// Print the name of each card in the deck List.
	public void printDeck() {
		for (Card c : deck) {
			System.out.println(c.getName());			
		} // end for
	} // end printDeck
		
} // end CLASS
