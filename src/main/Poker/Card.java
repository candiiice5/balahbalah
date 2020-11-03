package Poker;

public class Card {
	protected String suit;
	protected String cardNum;
	
	public Card(String suit, String cardNum) {
		this.suit = suit;
		this.cardNum = cardNum;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getCardNum() {
		return cardNum;
	}
}
