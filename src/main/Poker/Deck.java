package Poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {
	private List<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		String[] suit = {"Diamond", "Spade", "Heart", "Club"};
		
		String[] cardNum = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		
		for(int i = 0; i <= 3; i++) {
			for(int j = 0; j <= 12; j++) {
				deck.add(new Card(suit[i], cardNum[j]));
			}
		}
	}
	
	public List<Card> getDeck() {
		return deck;
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public void showDeck() {
		for(int i = 0; i < deck.size(); i++) {
			System.out.print(deck.get(i).getSuit() + deck.get(i).getCardNum());
		}
	}
}
