package ch7;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * For Question 7.1
 * Design the data structures for a generic deck of cards.
 * Explain how you would subclass it to implement particular card games.
 */

public class Card {
	public enum Pattern{
		CLUBS(1),SPADES(2),HEARTS(3),DIAMONDS(4);
		int value;
		
		//Constructor to retrieve which pattern the card is
		private Pattern(int v){
			value = v;
		}
	};
	
	private int cardValue;
	private Pattern pattern;
	
	public Card(int n, Pattern p){
		cardValue = n;
		pattern = p;
	}
	
	//Getter
	public int getValue(){
		return cardValue;
	}
	
	public Pattern getPattern(){
		return pattern;
	}
	
	
}
