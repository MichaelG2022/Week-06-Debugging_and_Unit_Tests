package week6WarCardGame;

public class Card {
	
	// FIELDS
	private int value;
	private String name;
	
	// METHODS
	
	// Describe the card - return the card name and card value.
	public String describeCard(Card card) {
		return (card.getName() + " (Value: " + card.getValue() + ")");		
	} // end describeCard
	
	// GETTERS AND SETTERS
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}  // end CLASS
