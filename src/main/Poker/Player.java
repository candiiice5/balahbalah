package Poker;

import java.util.List;
import java.util.ArrayList;

public class Player {
	private int PlayerNum;
	private String PlayerName;
	private List<Card> IndDeck = new ArrayList<Card>();
	
	public Player(int PlayerNum, String PlayerName) {
		this.PlayerNum = PlayerNum;
		this.PlayerName = PlayerName;
	}
	
	public List<Card> getIndDeck() {
		return IndDeck;
	}
	
	public void setIndDeck(Card card) {
		IndDeck.add(card);
	}
	
	public void showIndDeck() {
		for(int i = 0; i < IndDeck.size(); i++) {
			System.out.print(IndDeck.get(i).getSuit() + IndDeck.get(i).getCardNum());
		}
		System.out.print("\n");
	}
	
	public int getPlayerNum() {
		return PlayerNum;
	}
	
	public String getPlayerName() {
		return PlayerName;
	}
	
	public void removeDuplicates() {
		int a = 0;
		
		while(a < IndDeck.size()) {
			boolean pairRemoved = false;
			
			if(IndDeck.size() == 1) break;
			
			for(int b = 1; b < IndDeck.size() - a; b++) {
				if(IndDeck.get(a).getCardNum() == IndDeck.get(a + b).getCardNum()) {
					IndDeck.remove(a + b);
					
					IndDeck.remove(a);
					
					pairRemoved = true;
				}
			}
			//showIndDeck();
			if(!pairRemoved) a++;
		}
	}

	public void removeCard(int IndexToRemove) {
		IndDeck.remove(IndexToRemove);
	}
}
