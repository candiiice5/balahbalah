package Poker;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class GameStart {
	
	public int getBiggestHand(List<Player> players) {
		int biggestHand = players.get(0).getIndDeck().size();
		int pBigHand = 0;
		for(int i = 0; i <= 3; i++) {
			if(players.get(i).getIndDeck().size() > biggestHand) {
				pBigHand = i;
			}
		}
		return pBigHand;
	}
	
	public static void main(String[] args) {
		GameStart round = new GameStart();
		
		Scanner input = new Scanner(System.in);
		
		Deck deck = new Deck();
		
		deck.shuffle();
		
		//deck.showDeck();
		
		List<Player> players = new ArrayList<Player>();
		
		for(int i = 0; i <= 3; i++) {
			players.add(new Player(i, "i"));
			for(int j = 0; j <= 12; j++) {
				players.get(i).setIndDeck(deck.getDeck().get((i+ 1) * (j + 1) - 1));
			}
			//players.get(i).showIndDeck();
			players.get(i).removeDuplicates();
		}
		
		int pBigHand = round.getBiggestHand(players);
		
		//System.out.println(round.getBiggestHand(players));
		
		for(int i = pBigHand; i <= pBigHand + 3; i++) {
			if(i > 3) {
				players.get(i - 4).showIndDeck();
				
				System.out.println("Choose from 1 to " + players.get(i - 4).getIndDeck().size());
				
				int number = input.nextInt();
				
				Card cardPicked = players.get(i - 4).getIndDeck().get(number - 1);
				
				players.get(i - 3).setIndDeck(cardPicked);
				
				System.out.println(cardPicked.getSuit() + cardPicked.getCardNum());
			}
			else {
				players.get(i).showIndDeck();
				
				System.out.println("Choose from 1 to " + players.get(i).getIndDeck().size());
				
				int number = input.nextInt();
				
				Card cardPicked = players.get(i).getIndDeck().get(number - 1);
				
				if(i == 3) {
					players.get(0).setIndDeck(cardPicked);
				}
				else {
					players.get(i + 1).setIndDeck(cardPicked);
				}
				
				System.out.println(cardPicked.getSuit() + cardPicked.getCardNum());
			}
		}
		
		for(int i = 0; i <= 3; i++) {
			players.get(i).showIndDeck();
		}
		
		input.close();
	}
}
