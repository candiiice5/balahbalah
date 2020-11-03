package Poker;

import java.util.ArrayList;
import java.util.List;

public class GameStart {
	public static void main(String[] args) {
		GameStart round = new GameStart();
		
		Deck deck = new Deck();
		
		deck.shuffle();
		
		//deck.showDeck();
		
		List<Player> players = new ArrayList<Player>();
		
		for(int i = 0; i <= 3; i++) {
			players.add(new Player(i, "i"));
			for(int j = 0; j <= 12; j++) {
				players.get(i).setIndDeck(deck.getDeck().get((i+ 1) * (j + 1) - 1));
			}
			players.get(i).showIndDeck();
			players.get(i).removeDuplicates();
		}
	}
}
